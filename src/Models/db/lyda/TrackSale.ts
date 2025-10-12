import {Sale} from "../../Sale.ts";

export interface TrackSale extends Sale {
    track_id: number;
}