package com.samson.printCompany.repos;

import com.samson.printCompany.models.Clothes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClothesRepo extends JpaRepository<Clothes, Integer> {

    default Clothes addClothes(List<Clothes> all, Clothes clothes){

        for (Clothes value: all){
            if (value.getClothesName().equals(clothes.getClothesName())){
                if (value.getClothesBrand().equals(clothes.getClothesBrand())){
                    if (value.getClothesSize().equals(clothes.getClothesSize())){
                        if (value.getClothesColor().equals(clothes.getClothesColor())){
                            value.setClothesQuantity(value.getClothesQuantity() + clothes.getClothesQuantity());
                            return value;
                        }
                    }
                }
            }
        }

        return clothes;
    }
}
