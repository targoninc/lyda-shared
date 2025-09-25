export interface ActionLog {
    id: number;
    user_id: number;
    action_name: string;
    actioned_user_id: number;
    additional_info: string;
    created_at: string;
}