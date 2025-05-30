import {Album} from "./db/lyda/Album.ts";
import {Playlist} from "./db/lyda/Playlist.ts";

export interface PlayingFrom {
    type: "album" | "playlist" | string;
    name: string;
    id: number;
    entity?: Album|Playlist;
}