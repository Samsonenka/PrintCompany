package com.samson.printCompany.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
public class History{

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

    public History() {
    }

    public History(Stock clothes, String status) {

        this.companyName = clothes.getClothesBrand();
        this.clothesName = clothes.getClothesName();
        this.clothesSize = clothes.getClothesSize();
        this.clothesQuantity = clothes.getClothesQuantity();
        this.clothesColor = clothes.getClothesColor();
        this.arrivalDate = LocalDate.now();
        arrivalStatus = status;
    }

    public History(@NotNull String companyName, @NotNull String clothesName,
                   @NotNull String clothesSize, @NotNull String clothesColor,
                   @NotNull int clothesQuantity, String status) {
        this.companyName = companyName;
        this.clothesName = clothesName;
        this.clothesSize = clothesSize;
        this.clothesColor = clothesColor;
        this.clothesQuantity = clothesQuantity;
        this.arrivalDate = LocalDate.now();
        this.arrivalStatus = status;
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
