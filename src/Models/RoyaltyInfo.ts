import {BoxPlotValues} from "./BoxPlotValues.ts";

export interface RoyaltyInfo {
    personal: {
        trackRoyaltyValues: BoxPlotValues;
        meanTrackRoyalty: number;
        paidTotal: number;
        available: number;
        totalRoyalties: number;
        paypalMail: string | null;
    };
    global: {
        meanTrackRoyalty: number;
        paidTotal: number;
        totalRoyalties: number;
        trackRoyaltyValues: BoxPlotValues;
        counts: {
            users: number;
            tracks: number;
            albums: number;
            playlists: number;
        }
    }
}