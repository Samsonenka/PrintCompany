package com.samson.printCompany.controllers;
import com.samson.printCompany.models.Orders;
import com.samson.printCompany.repos.OrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/add")
    public String addOrders(@RequestParam String orderNameFirm, @RequestParam String orderAddress,
                             @RequestParam String orderComments, ModelMap modelMap){

        if (orderComments == null){
            orderComments = "";
        }
        Orders orders = new Orders(orderNameFirm, orderAddress, orderComments);
        orderRepo.save(orders);

        modelMap.put("orders", orderRepo.findAll());

        return "orders";
    }

    @GetMapping("/addproduct/{orderID}")
    public String addProduct(@PathVariable int orderID, ModelMap modelMap){

        Orders order = orderRepo.findById(orderID).get();

        modelMap.put("order", order);

        return "consumption";
    }

    @PostMapping("/saveproduct/{orderID}")
    public String saveProduct(@PathVariable int orderID, @RequestParam String clothesName,
                              @RequestParam String clothesBrand, @RequestParam String clothesSize,
                              @RequestParam String clothesColor, @RequestParam int clothesQuantity,
                              ModelMap modelMap){

        Orders order = orderRepo.findById(orderID).get();

        modelMap.put("order", order);

        return "consumption";
    }
}
