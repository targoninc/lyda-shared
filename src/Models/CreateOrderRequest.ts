import * as z from "zod";
import {PaymentProvider} from "../Enums/PaymentProvider.ts";

export const CreateOrderRequest = z.object({
    type: z.enum(["album", "track"]),
    paymentProvider: z.enum(PaymentProvider),
    entityId: z.uint64(),
    priceInUsd: z.number().min(0.01).max(100).optional(),
});

export type CreateOrderRequest = z.infer<typeof CreateOrderRequest>;
