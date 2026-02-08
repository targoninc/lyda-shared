import {User} from "./User";

export interface Repost {
    user?: User;
    user_id: number;
    track_id: number;
    created_at: Date;
}
