import {User} from "./User";
import {AlbumTrack} from "./AlbumTrack";
import {Entity} from "@targoninc/ts-search";
import {InteractionMetadata} from "../../InteractionMetadata";
import {TrackLike} from "./TrackLike";
import {Visibility} from "../../../Enums/Visibility";

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
    visibility: Visibility;
    secretcode: string;
    has_cover: boolean;
    price: number;
    likes?: InteractionMetadata<TrackLike>;
    /*reposts?: InteractionMetadata<Repost>;
    comments?: InteractionMetadata<Comment>;*/
}
