package com.samson.printCompany.controllers;

import com.samson.printCompany.models.enums.ColorPrint;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/PriceManagement")
public class PriceManagementController {

    @GetMapping("/edit")
    public String editPrice(ModelMap modelMap){

        modelMap.put("colorPrint", ColorPrint.values());

        return "priceManagement";
    }
}
