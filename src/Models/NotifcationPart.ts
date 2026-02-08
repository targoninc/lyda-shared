/**
 * Represents a part of a notification that can be displayed as a separate component
 */
export interface NotificationPart {
    type: "profile" | "track" | "album" | "playlist";
    text?: string;
    id?: number;
}