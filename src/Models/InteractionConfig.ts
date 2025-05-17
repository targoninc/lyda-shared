import {InteractionType} from "../Enums/InteractionType.ts";

export interface InteractionConfig {
    type: InteractionType;
    toggleable?: boolean;
    icons: {
        default: string;
        interacted: string;
    }
    requiredOptions?: string[];
    optionalOptions?: string[];
}