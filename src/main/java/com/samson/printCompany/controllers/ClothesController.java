package com.samson.printCompany.controllers;

import com.samson.printCompany.models.Clothes;
import com.samson.printCompany.models.Size;
import com.samson.printCompany.repos.ClothesRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/clothes/")
public class ClothesController {

    @Autowired
    private ClothesRepo clothesRepo;

    @GetMapping("/showAll")
    public String showClothes(ModelMap modelMap){

        modelMap.put("clothes", clothesRepo.findAll());
        modelMap.put("size", Size.values());

        return "clothes";
    }

    @PostMapping("/add")
    public String addClothes(Clothes clothes, ModelMap modelMap){

        clothesRepo.save(clothes);
        modelMap.put("clothes", clothesRepo.findAll());

        return "clothes";
    }


}
