import { StandardEntity } from "./base/sys$StandardEntity";
import { Shop } from "./easyfood_Shop";
import { User } from "./base/sec$User";
import { OrderDetail } from "./easyfood_OrderDetail";
export class Order extends StandardEntity {
  static NAME = "easyfood_Order";
  nr?: string | null;
  shop?: Shop | null;
  user?: User | null;
  orderDate?: any | null;
  totalPrice?: any | null;
  orderDetails?: OrderDetail[] | null;
  remark?: string | null;
}
export type OrderViewName = "_minimal" | "_local" | "_base" | "order-view";
export type OrderView<V extends OrderViewName> = V extends "_local"
  ? Pick<Order, "id" | "nr" | "orderDate" | "totalPrice" | "remark">
  : V extends "_base"
  ? Pick<Order, "id" | "nr" | "orderDate" | "totalPrice" | "remark">
  : V extends "order-view"
  ? Pick<
      Order,
      | "id"
      | "nr"
      | "orderDate"
      | "totalPrice"
      | "remark"
      | "shop"
      | "user"
      | "orderDetails"
    >
  : never;
