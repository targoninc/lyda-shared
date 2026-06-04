import {User} from "./User";
import {Track} from "./Track";
import {InteractionMetadata} from "../../InteractionMetadata";
import {CommentLike} from "./CommentLike";

export interface Comment {
    comments?: Comment[];
    user?: User;
    track?: Track;
    canEdit?: boolean;
    likes?: InteractionMetadata<CommentLike>;
    id: number;
    parent_id: number;
    track_id: number;
    user_id: number;
    content: string;
    created_at: Date;
    potentially_harmful: boolean;
    hidden: boolean;
}
