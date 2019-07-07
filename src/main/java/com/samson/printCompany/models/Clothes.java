package com.samson.printCompany.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Clothes {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int clothesID;

    @NotNull
    private String clothesName;
    @NotNull
    private String clothesBrand;
    @NotNull
    private String clothesSize;
    @NotNull
    private int clothesQuantity;

    public Clothes() {
    }

    public Clothes(@NotNull String clothesName, @NotNull String clothesBrand, @NotNull String clothesSize, @NotNull int clothesQuantity) {
        this.clothesName = clothesName;
        this.clothesBrand = clothesBrand;
        this.clothesSize = clothesSize;
        this.clothesQuantity = clothesQuantity;
    }

    public int getClothesID() {
        return clothesID;
    }

    public String getClothesName() {
        return clothesName;
    }

    public String getClothesBrand() {
        return clothesBrand;
    }

    public String getClothesSize() {
        return clothesSize;
    }

    public int getClothesQuantity() {
        return clothesQuantity;
    }

    public void setClothesName(String clothesName) {
        this.clothesName = clothesName;
    }

    public void setClothesBrand(String clothesBrand) {
        this.clothesBrand = clothesBrand;
    }

    public void setClothesSize(String clothesSize) {
        this.clothesSize = clothesSize;
    }

    public void setClothesQuantity(int clothesQuantity) {
        this.clothesQuantity = clothesQuantity;
    }
}
