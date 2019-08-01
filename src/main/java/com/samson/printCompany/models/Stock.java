package com.samson.printCompany.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
public class Stock {

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
    private String clothesColor;
    @NotNull
    private int clothesQuantity;

    public Stock() {
    }

    public Stock(@NotNull String clothesName, @NotNull String clothesBrand,
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


    public Stock addClothes(List<Stock> all) {

        for (Stock value: all){
            if (value.getClothesName().equals(clothesName)){
                if (value.getClothesBrand().equals(clothesBrand)){
                    if (value.getClothesSize().equals(clothesSize)){
                        if (value.getClothesColor().equals(clothesColor)){
                            value.setClothesQuantity(value.getClothesQuantity() + clothesQuantity);
                            return value;
                        }
                    }
                }
            }
        }
        return this;
    }
}
