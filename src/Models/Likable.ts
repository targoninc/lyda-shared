import {TrackLike} from "./db/lyda/TrackLike.ts";
import {AlbumLike} from "./db/lyda/AlbumLike.ts";
import {PlaylistLike} from "./db/lyda/PlaylistLike.ts";

/**
 * A generic interface for an entity that has an array of likes attached to it
 */
export interface Likable {
    likes?: (TrackLike | AlbumLike | PlaylistLike)[];
}