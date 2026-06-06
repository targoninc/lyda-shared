export interface TrackMetadata {
    track_id: number;
    bpm: number | null;
    bpm_confidence: number | null;
    key: string | null;
    key_scale: string | null;
    key_strength: number | null;
    energy: number | null;
    danceability: number | null;
    dynamic_complexity: number | null;
    flatness: number | null;
    genre_suggestions: string | null;
    created_at: Date;
}
