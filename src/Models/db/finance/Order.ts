export interface Order {
    id: string;
    payment_provider: string;
    item_type: string;
    provider_order_id: string;
    provider_status: string;
    status: string;
    amount_ct: number;
    user_id: string;
    item_id: number;
    created_at: Date;
    updated_at: Date;
}