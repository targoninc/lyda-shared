import {Track} from "./db/lyda/Track.ts";

/**
 * A generic interface for tracks in lists (e.g. albums or playlists)
 */
export interface ListTrack {
    track_id: number;
    position: number;
    track?: Track;
}