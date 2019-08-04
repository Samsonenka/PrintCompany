package com.samson.printCompany.logics;

import com.samson.printCompany.models.ClothesOrder;
import com.samson.printCompany.models.History;
import com.samson.printCompany.models.Orders;
import com.samson.printCompany.models.Stock;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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
}