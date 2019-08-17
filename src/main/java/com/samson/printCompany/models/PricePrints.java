package com.samson.printCompany.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.List;

@Entity
public class PricePrints {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int priceID;

    private float pricePrint;
    private String colorPrint;

    public PricePrints() {
    }

    public PricePrints(float price, String color) {
        this.pricePrint = price;
        this.colorPrint = color.toUpperCase();
    }

    public int getPriceID() {
        return priceID;
    }

    public float getPricePrint() {
        return pricePrint;
    }

    public String getColorPrint() {
        return colorPrint;
    }

    public void setPricePrint(float pricePrint) {
        this.pricePrint = pricePrint;
    }

    public void setColorPrint(String colorPrint) {
        this.colorPrint = colorPrint;
    }

    public PricePrints addPrice(List<PricePrints> all) {

        for (PricePrints value: all){
            if (value.getColorPrint().equals(colorPrint)){
                value.setPricePrint(pricePrint);
                return value;
            }
        }
        return this;
    }

    public float getPriceByColor(String colorPrintOrder, List<PricePrints> all) {

        for (PricePrints value: all){
            if (value.colorPrint.equals(colorPrintOrder)){
                return value.pricePrint;
            }
        }
        return 0;
    }
}
