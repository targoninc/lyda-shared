export interface BannedIp {
    ip: string;
    banned_at: Date;
    banned_by: number;
    reason: string;
}
