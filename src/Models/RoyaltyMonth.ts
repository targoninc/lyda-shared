export interface RoyaltyMonth {
    month: number;
    year: number;
    hasEarnings: boolean;
    streamingEarnings: number;
    saleEarnings: number;
    artistRoyalties: number;
    trackRoyalties: number;
    calculated: boolean;
    approved: boolean;
}