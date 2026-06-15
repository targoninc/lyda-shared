import {Entity} from "@targoninc/ts-search";

export interface UserLink extends Entity {
    id: number;
    user_id: number;
    url: string;
    title: string | null;
    created_at: Date;
    updated_at: Date;
}
