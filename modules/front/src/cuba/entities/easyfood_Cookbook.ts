import { StandardEntity } from "./base/sys$StandardEntity";
import { Shop } from "./easyfood_Shop";
import { FileDescriptor } from "./base/sys$FileDescriptor";
export class Cookbook extends StandardEntity {
  static NAME = "easyfood_Cookbook";
  shop?: Shop | null;
  name?: string | null;
  price?: any | null;
  image?: FileDescriptor | null;
  ingredients?: string | null;
  remark?: string | null;
}
export type CookbookViewName =
  | "_minimal"
  | "_local"
  | "_base"
  | "cookbook-with-shop-view";
export type CookbookView<V extends CookbookViewName> = V extends "_minimal"
  ? Pick<Cookbook, "id" | "name">
  : V extends "_local"
  ? Pick<Cookbook, "id" | "name" | "price" | "ingredients" | "remark">
  : V extends "_base"
  ? Pick<Cookbook, "id" | "name" | "price" | "ingredients" | "remark">
  : V extends "cookbook-with-shop-view"
  ? Pick<
      Cookbook,
      "id" | "name" | "price" | "ingredients" | "remark" | "shop" | "image"
    >
  : never;
