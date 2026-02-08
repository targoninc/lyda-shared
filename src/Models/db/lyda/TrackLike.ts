import {User} from "./User";

export interface TrackLike {
    user?: User;
    user_id: number;
    track_id: number;
    created_at: Date;
}
