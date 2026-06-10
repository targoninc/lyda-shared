import {PaymentStatus} from "../../../Enums/PaymentStatus";

export interface Payout {
    id: number;
    payout_batch_id: string;
    user_id: number;
    amount_ct: number;
    currency_code: string;
    stripe_transfer_id: string | null;
    stripe_payout_id: string | null;
    reversed_amount_ct: number;
    status: PaymentStatus;
    created_at: Date;
    updated_at: Date;
}