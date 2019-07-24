package com.samson.printCompany.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int orderID;

    @NotNull
    private String orderNumber;
    @NotNull
    private String orderCompanyName;
    @NotNull
    private String orderCompanyAddress;
    @NotNull
    private LocalDate orderDate;
    @NotNull
    private String orderComments;
    @NotNull
    private double orderPrice;

    public Orders() {
    }

    public Orders(@NotNull String orderNumber, @NotNull String orderCompanyName,
                  @NotNull String orderCompanyAddress, @NotNull LocalDate orderDate,
                  @NotNull String orderComments) {
        this.orderNumber = orderNumber;
        this.orderCompanyName = orderCompanyName;
        this.orderCompanyAddress = orderCompanyAddress;
        this.orderDate = orderDate;
        this.orderComments = orderComments;
        this.orderPrice = 0;
    }

    public int getOrderID() {
        return orderID;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public String getOrderCompanyName() {
        return orderCompanyName;
    }

    public String getOrderCompanyAddress() {
        return orderCompanyAddress;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public String getOrderComments() {
        return orderComments;
    }

    public double getOrderPrice() {
        return orderPrice;
    }
}
