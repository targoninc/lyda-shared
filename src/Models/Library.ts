import {Track} from "./db/lyda/Track";
import {Album} from "./db/lyda/Album";
import {Playlist} from "./db/lyda/Playlist";

export interface Library {
    tracks: Track[];
    albums: Album[];
    playlists: Playlist[];
}