import {Album} from "./db/lyda/Album.ts";
import {Playlist} from "./db/lyda/Playlist.ts";

/**
 * Represents the source from where media is currently being played.
 */
export interface PlayingFrom {
    type: "album" | "playlist" | string;
    name: string;
    id: number;
    entity?: Album|Playlist;
}