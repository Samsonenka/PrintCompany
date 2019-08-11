package com.samson.printCompany.logics;

import com.samson.printCompany.models.ClothesOrder;
import com.samson.printCompany.models.History;
import com.samson.printCompany.models.Orders;
import com.samson.printCompany.models.Stock;

import java.time.LocalDate;
import java.util.*;

public class FilterList {

    public List<History> filterListByDate(List<History> arrivalList, LocalDate date) {

        for (int i = 0; i < arrivalList.size(); i++){

            History arrival = arrivalList.get(i);

            if (!arrival.getArrivalDate().isBefore(date) && !arrival.getArrivalDate().isAfter(date)){
                arrivalList.remove(arrivalList.get(i));
                arrivalList.add(0, arrival);
            }
        }
        return arrivalList;
    }

    public List<ClothesOrder> findClothesByOrderID(Orders order, List<ClothesOrder> all) {

        List<ClothesOrder> clothesOrderList = new ArrayList<>();

        for (ClothesOrder clothesOrder: all){
            if (clothesOrder.getOrderID() == order.getOrderID()){
                clothesOrderList.add(clothesOrder);
            }
        }
        return clothesOrderList;
    }

    public Set<String> removeReplaysColors(List<Stock> all) {

        List<String> stringList = new ArrayList<>();

        for (Stock stock: all){
            stringList.add(stock.getClothesColor());
        }

        return new HashSet<>(stringList);
    }

    public Set<String> removeReplaysSize(List<Stock> all) {

        List<String> stringList = new ArrayList<>();

        for (Stock stock: all){
            stringList.add(stock.getClothesSize());
        }

        return new HashSet<>(stringList);
    }

    public List<Stock> filterByStock(List<Stock> stockList, String filter){

        List<Stock> newList = new ArrayList<>();
        String newFilter = filter.toUpperCase();

        for (Stock value: stockList){
            if (value.getClothesName().equals(newFilter)){
                newList.add(value);
            }else {
                if (value.getClothesBrand().equals(newFilter)){
                    newList.add(value);
                }else {
                    if (value.getClothesSize().equals(newFilter)){
                        newList.add(value);
                    }else {
                        if (value.getClothesColor().equals(newFilter)){
                            newList.add(value);
                        }
                    }
                }
            }
        }
        return newList;
    }
}