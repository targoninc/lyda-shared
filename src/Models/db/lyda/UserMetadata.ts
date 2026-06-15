import {Entity} from "@targoninc/ts-search";

export interface UserMetadata extends Entity {
    user_id: number;
    user_type: string;
    created_at: Date;
    updated_at: Date;
}
