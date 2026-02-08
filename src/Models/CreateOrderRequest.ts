import * as z from "zod";
import {PaymentProvider} from "../Enums/PaymentProvider";

export const CreateOrderRequest = z.object({
    type: z.enum(["album", "track"]),
    paymentProvider: z.enum(PaymentProvider),
    orderId: z.string(),
    entityId: z.number(),
});

export type CreateOrderRequest = z.infer<typeof CreateOrderRequest>;

