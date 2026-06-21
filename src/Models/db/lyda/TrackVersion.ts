import {Entity} from "@targoninc/ts-search";

export interface TrackVersion extends Entity {
    track_id: number;
    index: number;
    name: string | null;
    loudness_data: string;
    processed: boolean;
    length: number;
    created_at: Date;
}
