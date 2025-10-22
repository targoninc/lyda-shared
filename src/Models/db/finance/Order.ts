export interface Order {
    id: string;
    payment_provider: string;
    item_type: string;
    provider_request_id: string;
    provider_order_id: string;
    provider_status: string;
    status: string;
    user_id: string;
    item_id: number;
}