package com.samson.printCompany.controllers;

import com.samson.printCompany.models.PricePrints;
import com.samson.printCompany.repos.PricePrintsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/priceManagement")
public class PriceManagementController {

    @Autowired
    PricePrintsRepo pricePrintsRepo;

    @GetMapping("/showPrice")
    public String showPrice(ModelMap modelMap){

        modelMap.put("pricePrints", pricePrintsRepo.findAll());

        return "priceManagement";
    }

    @PostMapping("/addPrice")
    public String addPrice(@RequestParam float pricePrint, @RequestParam String colorPrint, ModelMap modelMap){

        PricePrints price = new PricePrints(pricePrint, colorPrint);

        PricePrints newPrice = price.addPrice(pricePrintsRepo.findAll());

        pricePrintsRepo.save(newPrice);
        modelMap.put("pricePrints", pricePrintsRepo.findAll());

        return "priceManagement";
    }
}
