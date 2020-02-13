package com.company.easyfood.service;

import com.company.easyfood.entity.Order;
import com.haulmont.cuba.core.global.DataManager;
import org.springframework.stereotype.Service;

import javax.inject.Inject;

@Service(OrderService.NAME)
public class OrderServiceBean implements OrderService {

    @Inject
    private DataManager dataManager;

    @Override
    public boolean isOrdered(String orderNr) {

        int todayOrderCount = dataManager.load(Order.class)
                .query("select o from easyfood_Order o where " +
                        "o.nr = :todayOrderNr and " +
                        "o.deleteTs is null")
                .parameter("todayOrderNr", orderNr)
                .list()
                .size();


        if (todayOrderCount > 0) {
            return true;
        }

        return false;
    }
}