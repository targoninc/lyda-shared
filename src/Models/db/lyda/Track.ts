import {TrackLike} from "./TrackLike.js";
import {Album} from "./Album.js";
import {Playlist} from "./Playlist.js";
import {Notification} from "./Notification.js";
import {Comment} from "./Comment.js";
import {TrackCollaborator} from "./TrackCollaborator.js";
import {User} from "./User.js";
import {Repost} from "./Repost.js";
import {InteractionMetadata} from "../../InteractionMetadata.ts";
import {Entity} from "@targoninc/ts-search";
import {Visibility} from "../../../Enums/Visibility.ts";

export interface Track extends Entity {
    repost_user_id?: number;
    repost?: Repost;
    collab?: TrackCollaborator,
    user?: User;
    playlists?: Playlist[];
    albums?: Album[];
    notifications?: Notification[];
    collaborators?: TrackCollaborator[];
    user_id: number;
    title: string;
    isrc: string;
    artistname: string;
    upc: string;
    visibility: Visibility;
    credits: string;
    loudness_data: string;
    genre: string;
    version: string;
    versionid: number;
    length: number;
    description: string;
    release_date: Date;
    updated_at: Date;
    created_at: Date;
    plays: number;
    secretcode: string;
    monetization: boolean;
    price: number;
    has_cover: boolean;
    processed: boolean;
    file_hash?: string;
    likes?: InteractionMetadata<TrackLike>;
    reposts?: InteractionMetadata<Repost>;
    comments?: InteractionMetadata<Comment>;
}