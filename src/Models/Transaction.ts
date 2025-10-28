export interface Transaction {
    total: number;
    tax: number;
    fees: number;
    paymentProcessor: string;
    currency: string;
    item_id?: number;
    item_name?: string;
    direction: "in" | "out";
    date: Date;
}
