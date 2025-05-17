import {User} from "./User.js";
import {Track} from "./Track.js";

export interface Comment {
    comments?: Comment[];
    user?: User;
    track?: Track;
    canEdit?: boolean;
    id: number;
    parent_id: number;
    track_id: number;
    user_id: number;
    content: string;
    created_at: Date;
    potentially_harmful: boolean;
    hidden: boolean;
}