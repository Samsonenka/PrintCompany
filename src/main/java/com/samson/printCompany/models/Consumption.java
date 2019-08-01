package com.samson.printCompany.models;

import com.samson.printCompany.models.enums.Status;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
public class Consumption {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int consumptionID;

    @NotNull
    private int orderID;

    @NotNull
    private String companyName;
    @NotNull
    private String clothesName;
    @NotNull
    private String clothesSize;
    @NotNull
    private String clothesColor;
    @NotNull
    private int clothesQuantity;
    @NotNull
    private double consumptionPrice;
    @NotNull
    private LocalDate consumptionDate;
    private String consumptionStatus;

    public Consumption() {
    }

    public Consumption(@NotNull int orderID, @NotNull String companyName,
                       @NotNull String clothesName, @NotNull String clothesSize,
                       @NotNull String clothesColor, @NotNull int clothesQuantity,
                       @NotNull double consumptionPrice) {
        this.orderID = orderID;
        this.companyName = companyName;
        this.clothesName = clothesName;
        this.clothesSize = clothesSize;
        this.clothesColor = clothesColor;
        this.clothesQuantity = clothesQuantity;
        this.consumptionPrice = consumptionPrice;
        this.consumptionDate = LocalDate.now();
        this.consumptionStatus = Status.consumption.toString();
    }

    public int getConsumptionID() {
        return consumptionID;
    }

    public int getOrderID() {
        return orderID;
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getClothesName() {
        return clothesName;
    }

    public String getClothesSize() {
        return clothesSize;
    }

    public String getClothesColor() {
        return clothesColor;
    }

    public int getClothesQuantity() {
        return clothesQuantity;
    }

    public double getConsumptionPrice() {
        return consumptionPrice;
    }

    public LocalDate getConsumptionDate() {
        return consumptionDate;
    }

    public String getConsumptionStatus() {
        return consumptionStatus;
    }
}
