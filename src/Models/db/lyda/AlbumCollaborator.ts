import {User} from "./User";
import {Album} from "./Album";
import {CollaboratorType} from "./CollaboratorType";

export interface AlbumCollaborator {
    collab_type?: CollaboratorType;
    album?: Album;
    user?: User;
    album_id: number;
    user_id: number;
    type: number;
    approved: boolean;
    denied: boolean;
    created_at: Date;
    updated_at: Date;
}
