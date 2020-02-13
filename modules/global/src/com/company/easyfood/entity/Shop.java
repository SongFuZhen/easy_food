package com.company.easyfood.entity;

import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.StandardEntity;
import com.haulmont.cuba.security.entity.User;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@NamePattern("%s|name")
@Table(name = "EASYFOOD_SHOP")
@Entity(name = "easyfood_Shop")
public class Shop extends StandardEntity {
    private static final long serialVersionUID = -5803582786203608665L;

    @NotNull
    @Column(name = "NAME", nullable = false)
    protected String name;

    @NotNull
    @Column(name = "PHONE", nullable = false)
    protected String phone;

    @NotNull
    @Column(name = "ADDRESS", nullable = false)
    protected String address;

    @Column(name = "REMARK")
    protected String remark;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MANAGER_ID")
    protected User manager;

    public void setManager(User manager) {
        this.manager = manager;
    }

    public User getManager() {
        return manager;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}