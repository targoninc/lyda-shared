export interface TrackLyrics {
    track_id: number;
    plain_text: string | null;
    timed_file: string | null;
    timed_format: "lrc" | "srt" | null;
}
