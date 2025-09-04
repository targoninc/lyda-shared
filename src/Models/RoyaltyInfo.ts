export interface RoyaltyInfo {
    personal: {
        trackRoyaltyValues: any;
        meanTrackRoyalty: number;
        paidTotal: number;
        available: number,
        totalRoyalties: number,
        paypalMail: string | null,
    },
    global: {
        meanTrackRoyalty: number;
        paidTotal: number,
        totalRoyalties: number,
        trackRoyaltyValues: any;
    }
}