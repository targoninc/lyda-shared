import {Follow} from "./Follow.js";
import {UserBadge} from "./UserBadge.js";
import {Usersetting} from "./Usersetting.js";
import {Badge} from "./Badge.js";
import {Subscription} from "../finance/Subscription.js";
import {UserEmail} from "./UserEmail.js";
import {Permission} from "./Permission.js";
import {Entity} from "@targoninc/ts-search";
import {UserTotp} from "./UserTotp.ts";
import {PublicKey} from "./PublicKey.ts";

export interface User extends Entity {
    permissions?: Permission[];
    subscription?: Subscription;
    settings?: Usersetting[];
    badges?: Badge[];
    userBadges?: UserBadge[];
    follows?: Follow[];
    following?: Follow[];
    totp?: UserTotp[];
    public_keys?: PublicKey[];
    id: number;
    username: string;
    mfa_enabled: boolean;
    emails: UserEmail[];
    password_hash: string;
    displayname: string;
    description: string;
    password_token: string|null;
    verified: boolean;
    verification_status: string;
    created_at: Date;
    updated_at: Date;
    deleted_at: Date;
    lastlogin?: Date;
    secondlastlogin?: Date;
    password_updated_at: Date;
    tos_agreed_at: Date;
    ip: string;
    has_avatar: boolean;
    has_banner: boolean;
    email_mfa_code: string;
    passkey_user_id: string;
}