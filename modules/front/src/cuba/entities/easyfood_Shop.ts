import { StandardEntity } from "./base/sys$StandardEntity";
import { User } from "./base/sec$User";
export class Shop extends StandardEntity {
  static NAME = "easyfood_Shop";
  name?: string | null;
  phone?: string | null;
  address?: string | null;
  remark?: string | null;
  manager?: User | null;
}
export type ShopViewName = "_minimal" | "_local" | "_base";
export type ShopView<V extends ShopViewName> = V extends "_minimal"
  ? Pick<Shop, "id" | "name">
  : V extends "_local"
  ? Pick<Shop, "id" | "name" | "phone" | "address" | "remark">
  : V extends "_base"
  ? Pick<Shop, "id" | "name" | "phone" | "address" | "remark">
  : never;
