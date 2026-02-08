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

/**
 * Represents a user entity with associated attributes and relationships.
 *
 * The `User` interface extends the `Entity` interface from our search library and defines additional properties
 * related to the user, including information about permissions, subscriptions, settings, badges,
 * security credentials, and activity logs.
 */
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
    giftedSubscriptions?: Subscription[];
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
