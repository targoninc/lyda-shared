export interface UserIp {
    user_id: number;
    ip: string;
    header: string;
    last_user_agent: string;
    location_info: string;
    created_at?: Date;
    updated_at?: Date;
}