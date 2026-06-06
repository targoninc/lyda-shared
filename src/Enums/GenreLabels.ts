import {Genre, DISCOGS_PARENT_GENRES} from "./Genre.ts";
import type {DiscogsParentGenre} from "./Genre.ts";

export interface GenreGroup {
    parent: DiscogsParentGenre;
    genres: Genre[];
}

const PARENT_PREFIXES: Record<DiscogsParentGenre, string> = {
    "Blues": "blues",
    "Brass & Military": "brass-&-military",
    "Children's": "children's",
    "Classical": "classical",
    "Electronic": "electronic",
    "Folk, World, & Country": "folk,-world,-&-country",
    "Funk / Soul": "funk-/-soul",
    "Hip Hop": "hip-hop",
    "Jazz": "jazz",
    "Latin": "latin",
    "Non-Music": "non-music",
    "Pop": "pop",
    "Reggae": "reggae",
    "Rock": "rock",
    "Stage & Screen": "stage-&-screen",
};

export const GenreByParent: Record<DiscogsParentGenre, Genre[]> = DISCOGS_PARENT_GENRES.reduce((acc, parent) => {
    const prefix = PARENT_PREFIXES[parent];
    acc[parent] = Object.values(Genre)
        .filter(g => g.startsWith(prefix + "---"))
        .sort((a, b) => (a.split("---")[1] ?? "").localeCompare(b.split("---")[1] ?? ""));
    return acc;
}, {} as Record<DiscogsParentGenre, Genre[]>);

export const GenreParentLookup: Record<string, DiscogsParentGenre> = Object.entries(GenreByParent).reduce((acc, [parent, genres]) => {
    for (const genre of genres) {
        acc[genre] = parent as DiscogsParentGenre;
    }
    return acc;
}, {} as Record<string, DiscogsParentGenre>);

export function getParentGenre(genre: Genre): DiscogsParentGenre {
    return GenreParentLookup[genre] ?? genre.split("---")[0] as DiscogsParentGenre;
}

export function getSubgenreDisplay(genre: Genre): string {
    const parts = genre.split("---");
    if (parts.length > 1 && parts[1]) {
        return parts[1]
            .replace(/-/g, " ")
            .replace(/&/g, "&")
            .replace(/\b\w/g, l => l.toUpperCase());
    }
    return genre
        .replace(/-/g, " ")
        .replace(/&/g, "&")
        .replace(/\b\w/g, l => l.toUpperCase());
}

export function getParentGenreGroups(): GenreGroup[] {
    return DISCOGS_PARENT_GENRES.map(parent => ({
        parent,
        genres: GenreByParent[parent],
    }));
}

export function getValidGenreValues(): string[] {
    return Object.values(Genre);
}

export function isValidGenre(value: string): value is Genre {
    return Object.values(Genre).includes(value as Genre);
}

export function filterGenres(search: string, exclude: Genre[] = []): Genre[] {
    const searchLower = search.toLowerCase();
    return Object.values(Genre)
        .filter(g => !exclude.includes(g))
        .filter(g => g.includes(searchLower) || getSubgenreDisplay(g).toLowerCase().includes(searchLower));
}

export function getTopGenresForParent(parent: DiscogsParentGenre, maxCount: number = 10): Genre[] {
    return (GenreByParent[parent] ?? []).slice(0, maxCount);
}
