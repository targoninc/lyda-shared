import * as z from "zod";

export const CreateOrderResponse = z.object({
    orderId: z.string().optional(),
    clientSecret: z.string().optional(),
    id: z.string().optional(),
    externalId: z.string().optional(),
});

export type CreateOrderResponse = z.infer<typeof CreateOrderResponse>;
