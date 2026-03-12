import {BoxPlotValues} from "./BoxPlotValues";

export interface RoyaltyInfo {
    personal: {
        trackRoyaltyValues: BoxPlotValues;
        meanTrackRoyalty: number;
        paidTotal: number;
        available: number;
        totalRoyalties: number;
        paypalMail: string | null;
        hasTaxInfo: boolean;
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