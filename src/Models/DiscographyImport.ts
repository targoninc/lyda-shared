export interface DiscographyRelease {
    title: string;
    upc?: string;
    artistName?: string;
    releaseDate?: string;
    genre?: string;
    description?: string;
    tracks: DiscographyTrack[];
}

export interface DiscographyTrack {
    title: string;
    isrc?: string;
    position?: number;
    duration?: number;
}

export interface DiscographyImportResult {
    platform: string;
    releasesImported: number;
    tracksImported: number;
    releasesSkipped: number;
    tracksSkipped: number;
    errors: string[];
}
