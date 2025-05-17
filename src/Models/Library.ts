import {Track} from "./db/lyda/Track.ts";
import {Album} from "./db/lyda/Album.ts";
import {Playlist} from "./db/lyda/Playlist.ts";

export interface Library {
    tracks: Track[];
    albums: Album[];
    playlists: Playlist[];
}