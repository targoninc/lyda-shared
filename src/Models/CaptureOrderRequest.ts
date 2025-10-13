import * as z from "zod";

export const CaptureOrderRequest = z.object({
    orderId: z.uuid()
});

export type CaptureOrderRequest = z.infer<typeof CaptureOrderRequest>;
