package com.samson.printCompany.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/orders/")
public class OrderController {

    @GetMapping("/showAll")
    public String showOrders(ModelMap modelMap){



        return "orders";
    }
}
