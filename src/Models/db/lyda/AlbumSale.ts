import {Sale} from "../../Sale.ts";

export interface AlbumSale extends Sale {
    album_id: number;
}