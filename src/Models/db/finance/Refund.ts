export interface Refund {
    id: number;
    external_provider: string;
    external_id: string;
    external_status: string;
    reason: string | null;
    created_at: Date;
    updated_at: Date;
}