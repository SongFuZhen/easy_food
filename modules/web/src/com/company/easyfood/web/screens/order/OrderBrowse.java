package com.company.easyfood.web.screens.order;

import com.company.easyfood.entity.OrderDetail;
import com.company.easyfood.service.OrderService;
import com.haulmont.cuba.gui.components.Button;
import com.haulmont.cuba.gui.components.GroupTable;
import com.haulmont.cuba.gui.components.Label;
import com.haulmont.cuba.gui.components.Table;
import com.haulmont.cuba.gui.model.CollectionContainer;
import com.haulmont.cuba.gui.model.CollectionLoader;
import com.haulmont.cuba.gui.screen.*;
import com.company.easyfood.entity.Order;
import com.haulmont.cuba.security.global.UserSession;

import javax.inject.Inject;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@UiController("easyfood_Order.browse")
@UiDescriptor("order-browse.xml")
@LookupComponent("ordersTable")
@LoadDataBeforeShow
public class OrderBrowse extends StandardLookup<Order> {

    @Inject
    private Label<String> alreadyOrderFoodLabel;

    @Inject
    private Button createButton;

    @Inject
    private OrderService orderService;

    @Inject
    private UserSession userSession;

    @Subscribe(id = "ordersDc", target = Target.DATA_CONTAINER)
    public void onOrdersDcCollectionChange(CollectionContainer.CollectionChangeEvent<Order> event) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
        LocalDateTime now = LocalDateTime.now();
        String todayNr = "O-" + formatter.format(now) + "-" + userSession.getUser().getLogin();

        if ("REMOVE_ITEMS".equals(event.getChangeType().toString())) {
            List<Order> orderList = (List<Order>) event.getChanges();
            String nr = orderList.get(0).getNr();

            if (todayNr.equals(nr)) {
                displayShow(true);
            }
        } else {
            if (orderService.isOrdered(todayNr)) {
                displayShow(false);
            }
        }
    }

    private void displayShow(boolean visible) {
        alreadyOrderFoodLabel.setVisible(!visible);
        createButton.setEnabled(visible);
    }

}