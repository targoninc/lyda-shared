import {NotificationReferenceType} from "../Enums/NotificationReferenceType.ts";

/**
 * Represents a reference for a notification.
 *
 * This interface defines the structure of a notification reference object,
 * which includes properties to identify and optionally associate an object with the notification.
 */
export interface NotificationReference {
    type: NotificationReferenceType;
    id: number;
    object?: any;
}