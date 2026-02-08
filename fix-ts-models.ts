import { readdir, readFile, writeFile } from "node:fs/promises";
import { join } from "node:path";

async function walk(dir: string): Promise<string[]> {
    const entries = await readdir(dir, { withFileTypes: true });
    const files = await Promise.all(
        entries.map(async (entry) => {
            const res = join(dir, entry.name);
            return entry.isDirectory() ? walk(res) : res;
        })
    );
    return files.flat();
}

async function fixFile(path: string) {
    if (!path.endsWith(".ts")) return;
    if (path.includes("fix-ts-models.ts")) return;
    const content = await readFile(path, "utf-8");
    let changed = false;
    let lines = content.split(/\n/);

    const newLines = lines.map((line, index) => {
        let newLine = line.replace(/\r$/, "");
        const trimmed = newLine.trim();

        // Fix imports - remove .ts and .js extensions
        if (newLine.includes('from "') || newLine.includes("from '")) {
            const updated = newLine.replace(/\.(ts|js)(['"])/g, "$2");
            if (updated !== newLine) {
                newLine = updated;
                changed = true;
            }
        }

        // Fix bigint -> number
        if (newLine.includes(": bigint")) {
            const updated = newLine.replace(/: bigint/g, ": number");
            if (updated !== newLine) {
                newLine = updated;
                changed = true;
            }
        }

        // Add semicolons to properties (simple heuristic)
        // Check if it's likely a property inside an interface/object
        // Matches: name: type or name?: type (where type doesn't contain ;)
        if (trimmed.match(/^\w+\??\s*:/)) {
             if (!trimmed.endsWith(";") && !trimmed.endsWith("{") && !trimmed.endsWith(",") && !trimmed.endsWith("(") && !trimmed.endsWith(")")) {
                 // Avoid lines that are part of other constructs
                 if (!trimmed.startsWith("import") && !trimmed.startsWith("export") && !trimmed.startsWith("return") && !trimmed.startsWith("type") && !trimmed.startsWith("constructor") && !trimmed.startsWith("public") && !trimmed.startsWith("private")) {
                    const indentMatch = line.match(/^\s+/);
                    const indent = indentMatch ? indentMatch[0] : "    ";
                    // Only apply if it's actually indented (likely a property)
                    if (indent.length > 0) {
                        newLine = indent + trimmed + ";";
                        changed = true;
                    }
                 }
             }
        }

        return newLine;
    });

    if (changed) {
        await writeFile(path, newLines.join("\n"), "utf-8");
        console.log(`Fixed: ${path}`);
    }
}

async function run() {
    const files = await walk("./src");
    for (const file of files) {
        await fixFile(file);
    }
}

run();
