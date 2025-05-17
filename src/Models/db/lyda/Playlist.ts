import {User} from "./User.js";
import {PlaylistLike} from "./PlaylistLike.js";
import {Entity} from "@targoninc/ts-search";
import {PlaylistTrack} from "./PlaylistTrack.ts";
import {InteractionMetadata} from "../../InteractionMetadata.ts";
import {TrackLike} from "./TrackLike.ts";
import {Repost} from "./Repost.ts";
import {Comment} from "./Comment.ts";

export interface Playlist extends Entity {
    tracks?: PlaylistTrack[];
    user?: User;
    id: number;
    user_id: number;
    title: string;
    description: string;
    created_at: Date;
    updated_at: Date;
    visibility: string;
    has_cover: boolean;
    secretcode: string;
    likes?: InteractionMetadata<TrackLike>;
    /*reposts?: InteractionMetadata<Repost>;
    comments?: InteractionMetadata<Comment>;*/
}