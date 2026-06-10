export interface StripeWebhook {
    id: string;
    type: string;
    received_at: Date;
    content: string;
    handled: boolean;
    updated_at: Date;
}
