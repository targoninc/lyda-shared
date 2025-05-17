import {TrackLike} from "./db/lyda/TrackLike.ts";
import {AlbumLike} from "./db/lyda/AlbumLike.ts";
import {PlaylistLike} from "./db/lyda/PlaylistLike.ts";

export interface Likable {
    likes?: (TrackLike | AlbumLike | PlaylistLike)[];
}