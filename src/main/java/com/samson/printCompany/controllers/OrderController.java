package com.samson.printCompany.controllers;
import com.samson.printCompany.logics.FilterList;
import com.samson.printCompany.models.ClothesOrder;
import com.samson.printCompany.models.History;
import com.samson.printCompany.models.Orders;
import com.samson.printCompany.models.Stock;
import com.samson.printCompany.models.enums.Status;
import com.samson.printCompany.repos.ClothesOrderRepo;
import com.samson.printCompany.repos.HistoryRepo;
import com.samson.printCompany.repos.OrderRepo;
import com.samson.printCompany.repos.StockRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Set;

@Controller
@RequestMapping("/orders/")
public class OrderController {

    @Autowired
    private OrderRepo orderRepo;

    @Autowired
    private ClothesOrderRepo clothesOrderRepo;

    @Autowired
    private StockRepo stockRepo;

    @Autowired
    private HistoryRepo historyRepo;

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
    public String showClothesOrder(@PathVariable int orderID, ModelMap modelMap){

        Orders order = orderRepo.findById(orderID).get();

        FilterList filterList = new FilterList();
        List<ClothesOrder> clothesOrderList = filterList.findClothesByOrderID(order, clothesOrderRepo.findAll());

        Set<String> setSize = filterList.removeReplaysSize(stockRepo.findAll());
        Set<String> setColor = filterList.removeReplaysColors(stockRepo.findAll());

        modelMap.put("clothesOrder", clothesOrderList);
        modelMap.put("order", order);
        modelMap.put("size", setSize);
        modelMap.put("color", setColor);

        return "showClothesOrder";
    }

    @PostMapping("/saveClothesOrder/{orderID}")
    public String saveClothesOrder(@PathVariable int orderID, @RequestParam String clothesOrderName,
                              @RequestParam String clothesOrderBrand, @RequestParam String clothesOrderSize,
                              @RequestParam String clothesOrderColor, @RequestParam int clothesOrderQuantity,
                              ModelMap modelMap){

        Orders order = orderRepo.findById(orderID).get();

        ClothesOrder clothesOrder = new ClothesOrder(clothesOrderName, clothesOrderBrand,
                                                        clothesOrderSize, clothesOrderColor,
                                                            clothesOrderQuantity, orderID);

        History history = new History(clothesOrderName, clothesOrderBrand,
                                                        clothesOrderSize, clothesOrderColor,
                                                        clothesOrderQuantity, Status.consumption.toString());
        clothesOrderRepo.save(clothesOrder);
        historyRepo.save(history);

        boolean isChange = clothesOrder.stockChange(stockRepo.findAll(), stockRepo);

        FilterList filterList = new FilterList();
        List<ClothesOrder> clothesOrderList = filterList.findClothesByOrderID(order, clothesOrderRepo.findAll());

        modelMap.put("order", order);
        modelMap.put("clothesOrder", clothesOrderList);
        modelMap.put("isChange", isChange);

        return "showClothesOrder";
    }

    @PostMapping("/deleteClothesOrder/{orderID}")
    public String deleteClothesOrder(@PathVariable int orderID, ModelMap modelMap){

        FilterList filterList = new FilterList();

        Orders order = orderRepo.findById(orderID).get();
        List<ClothesOrder> clothesOrderList = filterList.findClothesByOrderID(order, clothesOrderRepo.findAll());

        clothesOrderRepo.deleteAll(clothesOrderList);
        orderRepo.delete(order);

        modelMap.put("orders", orderRepo.findAll());

        return "orders";
    }
}
