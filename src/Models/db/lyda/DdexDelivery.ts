export interface DdexDelivery {
    id: number;
    message_id: string;
    sender_party_id: string;
    sender_name: string | null;
    recipient_party_id: string | null;
    user_id: number | null;
    message_created_at: Date | null;
    message_control_type: string | null;
    ern_version: string | null;
    release_profile: string | null;
    status: string;
    package_path: string | null;
    acknowledgement: string | null;
    errors: string | null;
    details: string | null;
    releases_imported: number;
    releases_updated: number;
    tracks_imported: number;
    tracks_updated: number;
    created_at: Date;
    updated_at: Date;
}
