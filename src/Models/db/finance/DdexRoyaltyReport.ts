export interface DdexRoyaltyReport {
    id: number;
    sender_party_id: string;
    sender_name: string | null;
    year: number;
    month: number;
    message_id: string;
    currency: string;
    total_amount_ct: number;
    streaming_amount_ct: number;
    sales_amount_ct: number;
    track_count: number;
    transaction_count: number;
    report_xml?: string;
    created_at: Date;
    updated_at: Date;
}
