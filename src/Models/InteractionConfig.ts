import {InteractionType} from "../Enums/InteractionType.ts";
import {EntityType} from "../Enums/EntityType.ts";

export interface InteractionConfig {
    type: InteractionType;
    entityType: EntityType;
    toggleable?: boolean;
    icons: {
        default: string;
        interacted: string;
    }
    requiredOptions?: string[];
    optionalOptions?: string[];
}