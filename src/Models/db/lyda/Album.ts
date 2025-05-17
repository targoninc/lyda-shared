import {User} from "./User.js";
import {AlbumTrack} from "./AlbumTrack.js";
import {Entity} from "@targoninc/ts-search";
import {InteractionMetadata} from "../../InteractionMetadata.ts";
import {TrackLike} from "./TrackLike.ts";

export interface Album extends Entity {
    tracks?: AlbumTrack[];
    user?: User;
    id: number;
    user_id: number;
    title: string;
    description: string;
    upc: string;
    release_date: Date;
    created_at: Date;
    updated_at: Date;
    visibility: string;
    secretcode: string;
    has_cover: boolean;
    price: number;
    likes?: InteractionMetadata<TrackLike>;
    /*reposts?: InteractionMetadata<Repost>;
    comments?: InteractionMetadata<Comment>;*/
}