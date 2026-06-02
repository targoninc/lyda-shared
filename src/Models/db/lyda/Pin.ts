import {Entity} from "@targoninc/ts-search";
import {Album} from "./Album";
import {Playlist} from "./Playlist";
import {Track} from "./Track";

export interface Pin extends Entity {
    id: number;
    user_id: number;
    entity_type: string;
    entity_id: number;
    created_at: Date;
    updated_at: Date;
    track?: Track;
    album?: Album;
    playlist?: Playlist;
}
