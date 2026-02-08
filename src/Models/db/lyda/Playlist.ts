import {User} from "./User";
import {PlaylistLike} from "./PlaylistLike";
import {Entity} from "@targoninc/ts-search";
import {PlaylistTrack} from "./PlaylistTrack";
import {InteractionMetadata} from "../../InteractionMetadata";
import {TrackLike} from "./TrackLike";
import {Repost} from "./Repost";
import {Comment} from "./Comment";
import {Visibility} from "../../../Enums/Visibility";

export interface Playlist extends Entity {
    tracks?: PlaylistTrack[];
    user?: User;
    id: number;
    user_id: number;
    title: string;
    description: string;
    created_at: Date;
    updated_at: Date;
    visibility: Visibility;
    has_cover: boolean;
    secretcode: string;
    likes?: InteractionMetadata<TrackLike>;
    /*reposts?: InteractionMetadata<Repost>;
    comments?: InteractionMetadata<Comment>;*/
}
