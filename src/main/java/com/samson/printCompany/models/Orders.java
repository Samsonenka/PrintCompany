package com.samson.printCompany.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Random;

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

    public Orders(@NotNull String orderCompanyName,
                  @NotNull String orderCompanyAddress,
                  @NotNull String orderComments) {
        this.orderCompanyName = orderCompanyName.toUpperCase();
        this.orderCompanyAddress = orderCompanyAddress.toUpperCase();
        this.orderDate = LocalDate.now();
        this.orderComments = orderComments;
        this.orderNumber = createOrderNumber(orderDate, orderCompanyName, orderCompanyAddress);
        this.orderPrice = 0;
    }

    public String createOrderNumber(LocalDate orderDate, String orderCompanyName, String orderCompanyAddress){

        String date = orderDate.format(DateTimeFormatter.BASIC_ISO_DATE).substring(4);
        String randomNumbers = createRandomNumber();
        String companyName = orderCompanyName.substring(0, 1).toUpperCase();
        String companyAddress = orderCompanyAddress.substring(0, 1).toUpperCase();

        return "" + date + "" + randomNumbers + "" + companyName + "" + companyAddress;
    }

    public String createRandomNumber(){

        Random rand = new Random();

        int num1 = rand.nextInt((9 - 1) + 1) + 1;
        int num2 = rand.nextInt((9 - 1) + 1) + 1;
        int num3 = rand.nextInt((9 - 1) + 1) + 1;
        int num4 = rand.nextInt((9 - 1) + 1) + 1;
        int num5 = rand.nextInt((9 - 1) + 1) + 1;

        return "" + num1 + "" + num2 + "" + num3 + "" + num4 + "" + num5 + "";
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
