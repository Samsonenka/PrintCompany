package com.samson.printCompany.logics;

import com.samson.printCompany.models.ClothesOrder;
import com.samson.printCompany.models.History;
import com.samson.printCompany.models.Orders;
import com.samson.printCompany.models.Stock;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FilterList {


    public List<Stock> filterListBySize(List<Stock> clothesList, String clothesSize) {

        for (int i = 0; i < clothesList.size(); i++) {

            Stock clothes = clothesList.get(i);

            if (clothes.getClothesSize().equals(clothesSize)){
                clothesList.remove(clothesList.get(i));
                clothesList.add(0, clothes);
            }
        }
        return clothesList;
    }

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
}