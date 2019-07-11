package com.samson.printCompany.models;

import com.samson.printCompany.models.enums.Status;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
public class Arrival {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int arrivalID;

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
    private LocalDate arrivalDate;
    private String arrivalStatus;

    public Arrival() {
    }

    public Arrival(Clothes clothes) {

        this.companyName = clothes.getClothesBrand();
        this.clothesName = clothes.getClothesName();
        this.clothesSize = clothes.getClothesSize();
        this.clothesQuantity = clothes.getClothesQuantity();
        this.clothesColor = clothes.getClothesColor();
        this.arrivalDate = LocalDate.now();
        arrivalStatus = Status.arrival.toString();
    }

    public String getArrivalStatus() {
        return arrivalStatus;
    }

    public int getArrivalID() {
        return arrivalID;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getClothesName() {
        return clothesName;
    }

    public void setClothesName(String clothesName) {
        this.clothesName = clothesName;
    }

    public String getClothesSize() {
        return clothesSize;
    }

    public void setClothesSize(String clothesSize) {
        this.clothesSize = clothesSize;
    }

    public String getClothesColor() {
        return clothesColor;
    }

    public void setClothesColor(String clothesColor) {
        this.clothesColor = clothesColor;
    }

    public int getClothesQuantity() {
        return clothesQuantity;
    }

    public void setClothesQuantity(int clothesQuantity) {
        this.clothesQuantity = clothesQuantity;
    }

    public LocalDate getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(LocalDate arrivalDate) {
        this.arrivalDate = arrivalDate;
    }
}
