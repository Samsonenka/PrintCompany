package com.samson.printCompany.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.util.List;

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
    private String clothesColor;
    @NotNull
    private int clothesQuantity;

    public Clothes() {
    }

    public Clothes(@NotNull String clothesName, @NotNull String clothesBrand,
                   @NotNull String clothesSize, @NotNull String clothesColor,
                   @NotNull int clothesQuantity) {
        this.clothesName = clothesName;
        this.clothesBrand = clothesBrand;
        this.clothesSize = clothesSize;
        this.clothesColor = clothesColor;
        this.clothesQuantity = clothesQuantity;
    }

    public String getClothesColor() {
        return clothesColor;
    }

    public void setClothesColor(String clothesColor) {
        this.clothesColor = clothesColor;
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
