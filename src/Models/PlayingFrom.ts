import {Album} from "./db/lyda/Album";
import {Playlist} from "./db/lyda/Playlist";
import {FeedType} from "../Enums/FeedType";

/**
 * Represents the source from where media is currently being played.
 */
export interface PlayingFrom {
    type?: FeedType | "album" | "playlist";
    name: string;
    id?: number;
    entity?: Album | Playlist;
}