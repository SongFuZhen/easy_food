package com.company.easyfood.web.screens.shop;

import com.haulmont.cuba.gui.screen.*;
import com.company.easyfood.entity.Shop;

@UiController("easyfood_Shop.browse")
@UiDescriptor("shop-browse.xml")
@LookupComponent("shopsTable")
@LoadDataBeforeShow
public class ShopBrowse extends StandardLookup<Shop> {
}