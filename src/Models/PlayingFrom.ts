import {Album} from "./db/lyda/Album.ts";
import {Playlist} from "./db/lyda/Playlist.ts";
import {FeedType} from "../Enums/FeedType.ts";

/**
 * Represents the source from where media is currently being played.
 */
export interface PlayingFrom {
    type?: FeedType | "album" | "playlist";
    name: string;
    id?: number;
    entity?: Album | Playlist;
}