export interface ClientError {
    id: string;
    created_at: Date;
    user_id?: number;
    message: string | Event;
    url?: string;
    line?: number;
    column?: number;
    error?: Error | string;
}
