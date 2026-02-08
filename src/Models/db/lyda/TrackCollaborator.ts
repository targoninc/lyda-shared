import {User} from "./User";
import {CollaboratorType} from "./CollaboratorType";
import {Track} from "./Track";

export interface TrackCollaborator {
    collab_type?: CollaboratorType;
    track?: Track;
    user?: User;
    track_id: number;
    user_id: number;
    type: number;
    approved: boolean;
    denied: boolean;
    created_at: Date;
    updated_at: Date;
}
