package com.company.easyfood.service;


public interface OrderService {
    String NAME = "easyfood_OrderService";

    boolean isOrdered(String orderNr);
}