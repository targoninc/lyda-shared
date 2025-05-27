import {ProgressState} from "../Enums/ProgressState.ts";
import {Signal, StringOrSignal} from "@targoninc/jess";

export interface ProgressPart {
    id: string;
    icon: string;
    text: string;
    state: ProgressState;
    title?: StringOrSignal;
    retryFunction?: Function;
    progress?: number;
}