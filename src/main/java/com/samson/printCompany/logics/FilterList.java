package com.samson.printCompany.logics;

import com.samson.printCompany.models.Clothes;
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
    }