import {User} from "./User";

export interface CommentLike {
    user?: User;
    comment_id: number;
    user_id: number;
    created_at: Date;
    updated_at: Date;
}
