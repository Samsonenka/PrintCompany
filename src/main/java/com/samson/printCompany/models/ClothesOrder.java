package com.samson.printCompany.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class ClothesOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  int clothesOrderID;

    @NotNull
    private String clothesOrderName;
    @NotNull
    private String clothesOrderBrand;
    @NotNull
    private String clothesOrderSize;
    @NotNull
    private String clothesOrderColor;
    @NotNull
    private int clothesOrderQuantity;

    @NotNull
    private double clothesOrderPrice;
    @NotNull
    private int orderID;

    public ClothesOrder() {
    }

    public ClothesOrder(@NotNull String clothesOrderName, @NotNull String clothesOrderBrand,
                        @NotNull String clothesOrderSize, @NotNull String clothesOrderColor,
                        @NotNull int clothesOrderQuantity, @NotNull double clothesOrderPrice,
                        @NotNull int orderID) {
        this.clothesOrderName = clothesOrderName;
        this.clothesOrderBrand = clothesOrderBrand;
        this.clothesOrderSize = clothesOrderSize;
        this.clothesOrderColor = clothesOrderColor;
        this.clothesOrderQuantity = clothesOrderQuantity;
        this.clothesOrderPrice = clothesOrderPrice;
        this.orderID = orderID;
    }

    public int getClothesOrderID() {
        return clothesOrderID;
    }

    public String getClothesOrderName() {
        return clothesOrderName;
    }

    public String getClothesOrderBrand() {
        return clothesOrderBrand;
    }

    public String getClothesOrderSize() {
        return clothesOrderSize;
    }

    public String getClothesOrderColor() {
        return clothesOrderColor;
    }

    public int getClothesOrderQuantity() {
        return clothesOrderQuantity;
    }

    public double getClothesOrderPrice() {
        return clothesOrderPrice;
    }

    public int getOrderID() {
        return orderID;
    }
}
