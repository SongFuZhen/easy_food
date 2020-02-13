package com.company.easyfood.entity;

import com.haulmont.cuba.core.entity.StandardEntity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.UUID;

@Table(name = "EASYFOOD_ORDER_DETAIL")
@Entity(name = "easyfood_OrderDetail")
public class OrderDetail extends StandardEntity {
    private static final long serialVersionUID = -6486866961938842887L;

    @NotNull
    @Column(name = "ORDER_NR", nullable = false)
    protected String orderNr;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "SHOP_ID")
    protected Shop shop;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "COOKBOOK_ID")
    protected Cookbook cookbook;

    @NotNull
    @Column(name = "QUANTITY", nullable = false)
    protected Integer quantity;

    @Column(name = "TOTAL_PRICE")
    protected BigDecimal totalPrice;

    @Column(name = "ORDER_ID")
    protected UUID orderId;

    public void setOrderId(UUID orderId) {
        this.orderId = orderId;
    }

    public UUID getOrderId() {
        return orderId;
    }

    public String getOrderNr() {
        return orderNr;
    }

    public void setOrderNr(String orderNr) {
        this.orderNr = orderNr;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Cookbook getCookbook() {
        return cookbook;
    }

    public void setCookbook(Cookbook cookbook) {
        this.cookbook = cookbook;
    }

    public Shop getShop() {
        return shop;
    }

    public void setShop(Shop shop) {
        this.shop = shop;
    }

}