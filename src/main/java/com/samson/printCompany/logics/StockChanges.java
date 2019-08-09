package com.samson.printCompany.logics;


import com.samson.printCompany.models.ClothesOrder;
import com.samson.printCompany.models.Stock;

import java.util.List;

public class StockChanges {


    public Stock takeOutOfStock(ClothesOrder clothesOrder, List<Stock> all) {

        Stock stock1 = null;
        
        for (Stock stock: all){

            stock1 = stock;
            
            if (clothesOrder.getClothesOrderName().equals(stock.getClothesName())){
                if (clothesOrder.getClothesOrderBrand().equals(stock.getClothesBrand())){
                    if (clothesOrder.getClothesOrderSize().equals(stock.getClothesSize())){
                        if (clothesOrder.getClothesOrderColor().equals(stock.getClothesColor())){
                            stock.setClothesQuantity(stock.getClothesQuantity() - clothesOrder.getClothesOrderQuantity());
                            return stock;
                        }
                    }
                }
                    
            }
        }
        return stock1;
    }
}
