import {User} from "./db/lyda/User";

export interface Sale {
    user?: User;
    user_id: number;
    amount_ct: number;
    created_at: Date;
}