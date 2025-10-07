export interface ClientError {
    id: string;
    created_at: Date;
    message: string | Event;
    url?: string;
    line?: number;
    column?: number;
    error?: Error;
}