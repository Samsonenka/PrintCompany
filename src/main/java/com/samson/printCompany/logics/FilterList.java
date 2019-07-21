package com.samson.printCompany.logics;

import com.samson.printCompany.models.Arrival;
import com.samson.printCompany.models.Clothes;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FilterList {


    public List<Clothes> filterListBySize(List<Clothes> clothesList, String clothesSize) {

        for (int i = 0; i < clothesList.size(); i++) {

            Clothes clothes = clothesList.get(i);

            if (clothes.getClothesSize().equals(clothesSize)){
                clothesList.remove(clothesList.get(i));
                clothesList.add(0, clothes);
            }
        }
        return clothesList;
    }

    public List<Arrival> filterListByDate(List<Arrival> arrivalList, Date date) {

        System.out.println(date);

        for (Arrival arrival: arrivalList){

                System.out.println(arrival.getArrivalDate());

            }

        return null;
    }

}