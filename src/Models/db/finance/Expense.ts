export interface Expense {
    id: number;
    year: number;
    month: number;
    day: number;
    amount_ct: number;
    label: string;
    expense_group: string;
}