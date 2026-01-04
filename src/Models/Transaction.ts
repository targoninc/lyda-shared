export interface Transaction {
    total: number;
    tax: number;
    fees: number;
    paymentProcessor: string;
    currency: string;
    item_id?: number;
    item_name?: string;
    item_type?: string;
    direction: "in" | "out";
    date: Date;
    refunded: number;
    refundReason?: string;
    refundStatus?: string;
}
