export interface StripeAccount {
    id: number;
    stripe_account_id: string;
    user_id: number;
    country: string;
    charges_enabled: boolean;
    payouts_enabled: boolean;
    details_submitted: boolean;
    onboarding_complete: boolean;
    created_at: Date;
    updated_at: Date;
}
