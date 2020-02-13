package com.company.easyfood.web.screens.order;

import com.company.easyfood.entity.OrderDetail;
import com.company.easyfood.entity.Shop;
import com.company.easyfood.web.screens.orderdetail.OrderDetailEdit;
import com.haulmont.cuba.core.entity.FileDescriptor;
import com.haulmont.cuba.core.global.Metadata;
import com.haulmont.cuba.gui.ScreenBuilders;
import com.haulmont.cuba.gui.UiComponents;
import com.haulmont.cuba.gui.components.*;
import com.haulmont.cuba.gui.model.CollectionContainer;
import com.haulmont.cuba.gui.model.CollectionLoader;
import com.haulmont.cuba.gui.screen.*;
import com.company.easyfood.entity.Order;
import com.haulmont.cuba.security.global.UserSession;

import javax.inject.Inject;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

@UiController("easyfood_Order.edit")
@UiDescriptor("order-edit.xml")
@EditedEntityContainer("orderDc")
//@LoadDataBeforeShow
public class OrderEdit extends StandardEditor<Order> {

    @Inject
    private CollectionLoader<OrderDetail> orderDetailsDl;

    @Inject
    private CollectionContainer<OrderDetail> orderDetailsDc;

    @Inject
    private UserSession userSession;

    @Inject
    private Metadata metadata;

    @Inject
    private ScreenBuilders screenBuilders;

    @Inject
    private Table<OrderDetail> orderDetailTable;

    @Inject
    private UiComponents uiComponents;


    private String orderNr;


    @Subscribe
    public void onInit(InitEvent event) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
        LocalDateTime now = LocalDateTime.now();

        orderNr = "O-" + formatter.format(now) + "-" + userSession.getUser().getLogin();

        // display Image
        orderDetailTableDisplayImage();
    }

    @Subscribe
    public void onBeforeShow(BeforeShowEvent event) {
        orderDetailsLoad();
        getScreenData().loadAll();
    }

    public void orderDetailsLoad() {
        if (getEditedEntity().getNr() != null) {
            orderNr = getEditedEntity().getNr();
        }

        orderDetailsDl.setParameter("shop", getEditedEntity().getShop());
        orderDetailsDl.setParameter("orderNr", orderNr);
        orderDetailsDl.load();
    }

    @Subscribe("shopField")
    public void onShopFieldValueChange(HasValue.ValueChangeEvent<Shop> event) {
        orderDetailsLoad();
    }

    @Subscribe("orderDetailTable.create")
    public void onOrderDetailTableCreate(Action.ActionPerformedEvent event) {
        OrderDetail orderDetail = metadata.create(OrderDetail.class);
        orderDetail.setShop(getEditedEntity().getShop());

        orderDetailShow(orderDetail);
    }

    @Subscribe("orderDetailTable.edit")
    public void onOrderDetailTableEdit(Action.ActionPerformedEvent event) {
        orderDetailShow(orderDetailTable.getSingleSelected());
    }

    private void orderDetailShow(OrderDetail orderDetail) {
        OrderDetailEdit orderDetailEdit = screenBuilders.screen(this)
                .withScreenClass(OrderDetailEdit.class)
                .build();

        orderDetailEdit.setEntityToEdit(orderDetail);
        orderDetailEdit.show();

        orderDetailTableDisplayImage();
    }

    @Subscribe
    public void onBeforeCommitChanges(BeforeCommitChangesEvent event) {
        Order order = getEditedEntity();

        // 新增
        if (order.getUser() == null) {
            order.setNr(orderNr);
            order.setUser(userSession.getUser());
            order.setOrderDate(LocalDate.now());
        }

        BigDecimal totalPrice = BigDecimal.ZERO;

        List<OrderDetail> orderDetails = orderDetailsDc.getItems();

        for (OrderDetail orderDetail : orderDetails) {
            totalPrice = totalPrice.add(orderDetail.getTotalPrice());
            orderDetail.setOrderId(getEditedEntity().getId());
        }

        order.setTotalPrice(totalPrice);
    }

    private void orderDetailTableDisplayImage() {
        orderDetailTable.addGeneratedColumn("cookbook.name", entity -> {
            Image image = uiComponents.create(Image.NAME);
            image.setScaleMode(Image.ScaleMode.CONTAIN);
            image.setHeight("40");
            image.setWidth("40");

            FileDescriptor imageFile = entity.getCookbook().getImage();
            image.setSource(FileDescriptorResource.class)
                    .setFileDescriptor(imageFile);

            Label cookbookName = uiComponents.create(Label.NAME);
            cookbookName.setValue(entity.getCookbook().getName());
            cookbookName.setAlignment(Component.Alignment.MIDDLE_LEFT);

            HBoxLayout hBoxLayout = uiComponents.create(HBoxLayout.NAME);
            hBoxLayout.setSpacing(true);
            hBoxLayout.add(image);
            hBoxLayout.add(cookbookName);

            return hBoxLayout;
        });
    }
}