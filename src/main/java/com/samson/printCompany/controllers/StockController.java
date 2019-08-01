package com.samson.printCompany.controllers;

import com.samson.printCompany.logics.FilterList;
import com.samson.printCompany.models.Arrival;
import com.samson.printCompany.models.Stock;
import com.samson.printCompany.models.enums.Size;
import com.samson.printCompany.repos.ArrivalRepo;
import com.samson.printCompany.repos.ClothesRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.*;

@Controller
@RequestMapping("/clothes/")
public class StockController {

    @Autowired
    private ClothesRepo clothesRepo;
    @Autowired
    private ArrivalRepo arrivalRepo;

    @GetMapping("/showAll")
    public String showClothes(ModelMap modelMap){

        modelMap.put("clothes", clothesRepo.findAll());
        modelMap.put("size", Size.values());

        return "clothes";
    }

    @PostMapping("/add")
    public String addClothes(Stock clothes, ModelMap modelMap){

        Stock newClothes = clothes.addClothes(clothesRepo.findAll());
        Arrival arrival = new Arrival(clothes);

        arrivalRepo.save(arrival);
        clothesRepo.save(newClothes);

        modelMap.put("clothes", clothesRepo.findAll());

        return "redirect:/clothes/showAll";
    }

    @GetMapping("/filter")
    public String filterClothes(@RequestParam String clothesSize, ModelMap modelMap){

        FilterList filterList = new FilterList();
        List<Stock> clothesList = filterList.filterListBySize(clothesRepo.findAll(), clothesSize);

        modelMap.put("clothes", clothesList);
        modelMap.put("size", Size.values());

        return "clothes";
    }


}
