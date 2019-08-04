package com.samson.printCompany.controllers;
import com.samson.printCompany.logics.FilterList;
import com.samson.printCompany.models.ClothesOrder;
import com.samson.printCompany.models.Orders;
import com.samson.printCompany.repos.ClothesOrderRepo;
import com.samson.printCompany.repos.OrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/orders/")
public class OrderController {

    @Autowired
    private OrderRepo orderRepo;

    @Autowired
    private ClothesOrderRepo clothesOrderRepo;

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

    @GetMapping("/showClothesOrder/{orderID}")
    public String addProduct(@PathVariable int orderID, ModelMap modelMap){

        Orders order = orderRepo.findById(orderID).get();

        FilterList filterList = new FilterList();
        List<ClothesOrder> clothesOrderList = filterList.findClothesByOrderID(order, clothesOrderRepo.findAll());

        modelMap.put("clothesOrder", clothesOrderList);
        modelMap.put("order", order);

        return "showClothesOrder";
    }

    @PostMapping("/saveClothesOrder/{orderID}")
    public String saveProduct(@PathVariable int orderID, @RequestParam String clothesOrderName,
                              @RequestParam String clothesOrderBrand, @RequestParam String clothesOrderSize,
                              @RequestParam String clothesOrderColor, @RequestParam int clothesOrderQuantity,
                              ModelMap modelMap){

        Orders order = orderRepo.findById(orderID).get();

        ClothesOrder clothesOrder = new ClothesOrder(clothesOrderName, clothesOrderBrand,
                                                        clothesOrderSize, clothesOrderColor,
                                                            clothesOrderQuantity, orderID);
        clothesOrderRepo.save(clothesOrder);

        modelMap.put("clothesOrder", clothesOrderRepo.findAll());
        modelMap.put("order", order);

        return "showClothesOrder";
    }
}
