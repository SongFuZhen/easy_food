// import { getMenuItems } from "@cuba-platform/react";
// export const menuItems = getMenuItems();

// Code below demonstrates how we can create SubMenu section
// Remove '/*' '*/' comments and restart app to get this block in menu

/*
// This is RouteItem object that we want to see in User Settings sub menu
const backToHomeRouteItem = {
  pathPattern: "/backToHome",
  menuLink: "/",
  component: null,
  caption: "home"
};
// SubMenu object
const userSettingsSubMenu = {
  caption: 'UserSettings', // add router.UserSettings key to src/i18n/en.json for valid caption
  items: [backToHomeRouteItem]};
// Add sub menu item to menu config
menuItems.push(userSettingsSubMenu);
*/

import { OrderManagement } from "./app/order/OrderManagement";
import { CookbookManagement } from "./app/cookbook/CookbookManagement";
import { ShopManagement } from "./app/shop/ShopManagement";

export const menuItemIcons = ["shop", "snippets", "account-book"];

export const menuItems = [
  {
    pathPattern: "/shopManagement/:entityId?",
    menuLink: "/shopManagement",
    component: ShopManagement,
    caption: "ShopManagement"
  },
  {
    pathPattern: "/cookbookManagement/:entityId?",
    menuLink: "/cookbookManagement",
    component: CookbookManagement,
    caption: "CookbookManagement"
  },
  {
    pathPattern: "/orderManagement/:entityId?",
    menuLink: "/orderManagement",
    component: OrderManagement,
    caption: "OrderManagement"
  }
];
