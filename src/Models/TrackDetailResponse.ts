import {Track} from "./db/lyda/Track";
import {TrackVersion} from "./db/lyda/TrackVersion";
import {TrackMetadata} from "./db/lyda/TrackMetadata";

export interface TrackDetailResponse {
    track: Track;
    metadata: TrackMetadata | null;
    canEdit: boolean;
    canDownload: boolean;
    canBuy: boolean;
    versions: TrackVersion[];
    latestVersion: number | undefined;
}
