import { StandardEntity } from "./base/sys$StandardEntity";
import { Order } from "./easyfood_Order";
import { Shop } from "./easyfood_Shop";
import { Cookbook } from "./easyfood_Cookbook";
export class OrderDetail extends StandardEntity {
  static NAME = "easyfood_OrderDetail";
  order?: Order | null;
  shop?: Shop | null;
  cookbook?: Cookbook | null;
  quantity?: number | null;
  totalPrice?: any | null;
}
export type OrderDetailViewName =
  | "_minimal"
  | "_local"
  | "_base"
  | "orderDetail-with-order-and-shop-and-cookbook-view";
export type OrderDetailView<V extends OrderDetailViewName> = V extends "_local"
  ? Pick<OrderDetail, "id" | "quantity" | "totalPrice">
  : V extends "_base"
  ? Pick<OrderDetail, "id" | "quantity" | "totalPrice">
  : V extends "orderDetail-with-order-and-shop-and-cookbook-view"
  ? Pick<
      OrderDetail,
      "id" | "quantity" | "totalPrice" | "order" | "shop" | "cookbook"
    >
  : never;
