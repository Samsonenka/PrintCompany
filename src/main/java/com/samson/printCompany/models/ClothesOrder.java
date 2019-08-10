package com.samson.printCompany.models;

import com.samson.printCompany.repos.StockRepo;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.util.List;

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
                        @NotNull int clothesOrderQuantity, @NotNull int orderID) {
        this.clothesOrderName = clothesOrderName.toUpperCase();
        this.clothesOrderBrand = clothesOrderBrand.toUpperCase();
        this.clothesOrderSize = clothesOrderSize.toUpperCase();
        this.clothesOrderColor = clothesOrderColor.toUpperCase();
        this.clothesOrderQuantity = clothesOrderQuantity;
        this.clothesOrderPrice = 0;
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


    public boolean stockChange(List<Stock> all, StockRepo stockRepo) {

        Stock stock = null;

        for (Stock value: all){
            stock = value;

            if (stock.getClothesName().equals(clothesOrderName) &
                  stock.getClothesBrand().equals(clothesOrderBrand) &
                     stock.getClothesColor().equals(clothesOrderColor) &
                        stock.getClothesSize().equals(clothesOrderSize) &
                          stock.getClothesQuantity() >= clothesOrderQuantity){

                stock.setClothesQuantity(stock.getClothesQuantity() - clothesOrderQuantity);
                stockRepo.save(stock);

                return true;
            }
        }
        stockRepo.save(stock);
        return false;
    }
}
