package com.company.easyfood.web.screens.shop;

import com.haulmont.cuba.gui.screen.*;
import com.company.easyfood.entity.Shop;
import com.haulmont.cuba.security.global.UserSession;

import javax.inject.Inject;

@UiController("easyfood_Shop.edit")
@UiDescriptor("shop-edit.xml")
@EditedEntityContainer("shopDc")
@LoadDataBeforeShow
public class ShopEdit extends StandardEditor<Shop> {

    @Inject
    private UserSession userSession;

    @Subscribe
    public void onBeforeCommitChanges(BeforeCommitChangesEvent event) {
        Shop shop = getEditedEntity();
        shop.setManager(userSession.getUser());
    }
}