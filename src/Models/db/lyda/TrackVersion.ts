import {Entity} from "@targoninc/ts-search";

export interface TrackVersion extends Entity {
    track_id: number;
    index: number;
    name: string | null;
    created_at: Date;
}
