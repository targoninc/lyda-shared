import {Follow} from "./Follow";
import {UserBadge} from "./UserBadge";
import {Usersetting} from "./Usersetting";
import {Badge} from "./Badge";
import {Subscription} from "../finance/Subscription";
import {UserEmail} from "./UserEmail";
import {Permission} from "./Permission";
import {Entity} from "@targoninc/ts-search";
import {UserTotp} from "./UserTotp";
import {PublicKey} from "./PublicKey";

export interface UserTaxinfo extends Entity {
    user_id: number;
    full_name: string;
    country_code_iso3166_a3: string;
    tax_number: string;
    region_code: string;
    address_line_1: string;
    address_line_2: string;
    created_at: Date;
    updated_at: Date;
}
