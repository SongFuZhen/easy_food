package com.company.easyfood.web.screens.orderdetail;

import com.company.easyfood.entity.Cookbook;
import com.company.easyfood.web.screens.order.OrderEdit;
import com.haulmont.cuba.gui.Screens;
import com.haulmont.cuba.gui.components.FileDescriptorResource;
import com.haulmont.cuba.gui.components.HasValue;
import com.haulmont.cuba.gui.components.Image;
import com.haulmont.cuba.gui.model.CollectionLoader;
import com.haulmont.cuba.gui.screen.*;
import com.company.easyfood.entity.OrderDetail;
import com.haulmont.cuba.security.global.UserSession;

import javax.inject.Inject;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@UiController("easyfood_OrderDetail.edit")
@UiDescriptor("order-detail-edit.xml")
@EditedEntityContainer("orderDetailDc")
//@LoadDataBeforeShow
public class OrderDetailEdit extends StandardEditor<OrderDetail> {

    @Inject
    private Screens screens;

    @Inject
    private CollectionLoader<Cookbook> cookbooksDl;

    @Inject
    private UserSession userSession;

    @Inject
    private Image image;

    @Subscribe
    public void onBeforeShow(BeforeShowEvent event) {
        cookbooksDl.setParameter("shop", getEditedEntity().getShop());
        getScreenData().loadAll();
    }

    @Subscribe
    public void onBeforeCommitChanges(BeforeCommitChangesEvent event) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
        LocalDateTime now = LocalDateTime.now();

        OrderDetail orderDetail = getEditedEntity();
        orderDetail.setOrderNr("O-" + formatter.format(now) + "-" + userSession.getUser().getLogin());
        orderDetail.setTotalPrice(orderDetail.getCookbook().getPrice().multiply(new BigDecimal(orderDetail.getQuantity())));
    }

    @Subscribe
    public void onAfterClose(AfterCloseEvent event) {
        for (Screen screen : screens.getOpenedScreens().getActiveScreens()) {
            if (screen.getClass().equals(OrderEdit.class)) {
                OrderEdit orderEdit = (OrderEdit) screen;
                orderEdit.orderDetailsLoad();
                break;
            }
        }
    }

    @Subscribe("cookbookField")
    public void onCookbookFieldValueChange(HasValue.ValueChangeEvent<Cookbook> event) {
        if (event.getValue() != null) {
            image.setSource(FileDescriptorResource.class).setFileDescriptor(event.getValue().getImage());
        }
    }

}