export interface CommentReport {
    id: number;
    comment_id: number;
    user_id: number;
    reason: string;
    description: string | null;
    created_at: Date;
    updated_at: Date;
}