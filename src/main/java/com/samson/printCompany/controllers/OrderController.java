package com.samson.printCompany.controllers;
import com.samson.printCompany.repos.OrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/orders/")
public class OrderController {

    @Autowired
    OrderRepo orderRepo;

    @GetMapping("/showAll")
    public String showOrders(ModelMap modelMap){

        modelMap.put("orders", orderRepo.findAll());

        return "orders";
    }
}
