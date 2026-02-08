import { readdir, mkdir, readFile, writeFile } from "node:fs/promises";
import { execFile } from "node:child_process";
import { join, relative, dirname, basename } from "node:path";
import { promisify } from "node:util";

const execFileAsync = promisify(execFile);

const SRC_ROOT = "./src";
const OUT_ROOT = "./kotlin-models"; // output folder root (mirrors src structure)
const KOTLIN_PACKAGE = "com.example.lydaandroid.model";
const PARALLELISM = 4;

// Recursively collect .ts files under a directory
async function getTsFilesRecursive(dir: string): Promise<string[]> {
    const entries = await readdir(dir, { withFileTypes: true });

    const files = await Promise.all(
        entries.map(async (entry) => {
            const fullPath = join(dir, entry.name);

            if (entry.isDirectory()) {
                return getTsFilesRecursive(fullPath);
            }

            if (
                entry.isFile() &&
                entry.name.endsWith(".ts") &&
                !entry.name.endsWith(".d.ts") &&
                entry.name !== "index.ts"
            ) {
                return [fullPath];
            }

            return [];
        }),
    );

    return files.flat();
}

function outPathForInputTs(tsFilePath: string): string {
    const rel = relative(SRC_ROOT, tsFilePath); // e.g. models/user/User.ts
    const relDir = dirname(rel); // e.g. models/user
    const nameNoExt = basename(rel, ".ts"); // e.g. User
    return join(OUT_ROOT, relDir, `${nameNoExt}.kt`);
}

async function convertOne(tsFile: string): Promise<void> {
    const outFile = outPathForInputTs(tsFile);
    await mkdir(dirname(outFile), { recursive: true });

    const args = [
        tsFile,
        "-o",
        outFile,
        "--lang",
        "kotlin",
        "--package",
        KOTLIN_PACKAGE,
    ];

    console.log(`quicktype ${args.join(" ")}`);

    try {
        const { stdout, stderr } = await execFileAsync("quicktype", args);

        if (stdout?.trim()) console.log(stdout.trim());
        if (stderr?.trim()) console.error(stderr.trim());

        // Post-process to add semicolons to property lines in data classes
        await addSemicolonsToKotlinFile(outFile);
    } catch (e: any) {
        // keep going so one failing model doesn't block the rest
        const msg = e?.message ?? String(e);
        console.error(`Failed generating for: ${tsFile}`);
        console.error(msg);
    }
}

async function addSemicolonsToKotlinFile(filePath: string): Promise<void> {
    try {
        const content = await readFile(filePath, "utf-8");
        const lines = content.split("\n");
        let inDataClass = false;
        let inEnum = false;
        const processedLines = lines.map((line, index) => {
            const trimmed = line.trim();

            if (trimmed.startsWith("data class")) {
                inDataClass = true;
            }
            if (trimmed.startsWith("enum class")) {
                inEnum = true;
            }

            if (inDataClass) {
                if (trimmed.startsWith(")")) {
                    inDataClass = false;
                } else {
                    const nextLine = lines[index + 1]?.trim() || "";
                    const isProperty =
                        trimmed.startsWith("val ") ||
                        trimmed.startsWith("var ");
                    const isAnnotation = trimmed.startsWith("@Json");

                    if (isProperty || isAnnotation) {
                        // If it ends with a comma, it definitely needs to be a semicolon
                        if (trimmed.endsWith(",")) {
                            if (isProperty) {
                                return line.slice(0, -1) + ";";
                            }
                        }

                        // If it's a property and doesn't have a semicolon yet, and the next line is a property, annotation or closing parenthesis
                        if (
                            isProperty &&
                            !trimmed.endsWith(";") &&
                            (nextLine.startsWith("val ") ||
                                nextLine.startsWith("var ") ||
                                nextLine.startsWith("@Json") ||
                                nextLine.startsWith(")"))
                        ) {
                            return line + ";";
                        }
                    }
                }
            }

            if (inEnum) {
                if (trimmed.endsWith("}")) {
                    inEnum = false;
                }
            }

            return line;
        });

        await writeFile(filePath, processedLines.join("\n"), "utf-8");
    } catch (err) {
        console.error(`Error post-processing ${filePath}:`, err);
    }
}

async function runWithConcurrency<T>(
    items: T[],
    concurrency: number,
    worker: (item: T) => Promise<void>,
): Promise<void> {
    const queue = items.slice();
    const workers = Array.from(
        { length: Math.min(concurrency, queue.length) },
        async () => {
            while (queue.length) {
                const item = queue.shift()!;
                await worker(item);
            }
        },
    );
    await Promise.all(workers);
}

console.log(`reading files from ${SRC_ROOT} recursively...`);
const tsFiles = await getTsFilesRecursive(SRC_ROOT);
console.log(`found ${tsFiles.length} TypeScript files under ${SRC_ROOT}.`);

await runWithConcurrency(tsFiles, PARALLELISM, convertOne);