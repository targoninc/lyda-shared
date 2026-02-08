import {User} from "./User";

export interface AlbumLike {
    user?: User;
    user_id: number;
    album_id: number;
    created_at: Date;
}
