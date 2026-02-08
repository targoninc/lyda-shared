import {TrackLike} from "./db/lyda/TrackLike";
import {AlbumLike} from "./db/lyda/AlbumLike";
import {PlaylistLike} from "./db/lyda/PlaylistLike";

/**
 * A generic interface for an entity that has an array of likes attached to it
 */
export interface Likable {
    likes?: (TrackLike | AlbumLike | PlaylistLike)[];
}