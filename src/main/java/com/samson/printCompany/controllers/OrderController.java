package com.samson.printCompany.controllers;
import com.samson.printCompany.logics.FilterList;
import com.samson.printCompany.models.ClothesOrder;
import com.samson.printCompany.models.Orders;
import com.samson.printCompany.models.PricePrints;
import com.samson.printCompany.repos.*;
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

    @Autowired
    private PricePrintsRepo pricePrintsRepo;

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

        ClothesOrder clothesOrder = new ClothesOrder();

        FilterList filterList = new FilterList();
        List<ClothesOrder> clothesOrderList = filterList.findClothesByOrderID(order, clothesOrderRepo.findAll());


        Set<String> setName = filterList.removeReplaysName(stockRepo.findAll());
        Set<String> setBrand = filterList.removeReplaysBrand(stockRepo.findAll());
        Set<String> setSize = filterList.removeReplaysSize(stockRepo.findAll());
        Set<String> setColor = filterList.removeReplaysColors(stockRepo.findAll());

        String sumPriceList = String.format("%.2f", clothesOrder.sumPriceList(clothesOrderList));

        modelMap.put("clothesOrder", clothesOrderList);
        modelMap.put("order", order);
        modelMap.put("name", setName);
        modelMap.put("brand", setBrand);
        modelMap.put("size", setSize);
        modelMap.put("color", setColor);
        modelMap.put("pricePrints", pricePrintsRepo.findAll());
        modelMap.put("sumPrice", clothesOrder);
        modelMap.put("sumPriceList", sumPriceList);

        return "showClothesOrder";
    }

    @PostMapping("/saveClothesOrder/{orderID}")
    public String saveClothesOrder(@PathVariable int orderID, @RequestParam String clothesOrderName,
                              @RequestParam String clothesOrderBrand, @RequestParam String clothesOrderSize,
                              @RequestParam String clothesOrderColor, @RequestParam int printID, @RequestParam int clothesOrderQuantity,
                              ModelMap modelMap){

        Orders order = orderRepo.findById(orderID).get();

        PricePrints pricePrints = pricePrintsRepo.findById(printID).get();
        float price = pricePrints.getPriceByColor(pricePrints.getColorPrint(), pricePrintsRepo.findAll());

        ClothesOrder clothesOrder = new ClothesOrder(clothesOrderName, clothesOrderBrand,
                                                        clothesOrderSize, clothesOrderColor,
                                                            clothesOrderQuantity, price, orderID);

        boolean isChange = clothesOrder.stockChange(stockRepo.findAll(), stockRepo, clothesOrderRepo, historyRepo);

        FilterList filterList = new FilterList();
        List<ClothesOrder> clothesOrderList = filterList.findClothesByOrderID(order, clothesOrderRepo.findAll());

        Set<String> setName = filterList.removeReplaysName(stockRepo.findAll());
        Set<String> setBrand = filterList.removeReplaysBrand(stockRepo.findAll());
        Set<String> setSize = filterList.removeReplaysSize(stockRepo.findAll());
        Set<String> setColor = filterList.removeReplaysColors(stockRepo.findAll());

        String sumPrice = String.format("%.2f", clothesOrder.sumPrice());
        String sumPriceList = String.format("%.2f", clothesOrder.sumPriceList(clothesOrderList));

        modelMap.put("order", order);
        modelMap.put("clothesOrder", clothesOrderList);
        modelMap.put("isChange", isChange);
        modelMap.put("name", setName);
        modelMap.put("brand", setBrand);
        modelMap.put("size", setSize);
        modelMap.put("color", setColor);
        modelMap.put("pricePrintsRepo", pricePrintsRepo.findAll());
        modelMap.put("sumPrice", sumPrice);
        modelMap.put("sumPriceList", sumPriceList);

        return "showClothesOrder";
    }

    @PostMapping("/deleteOrder/{orderID}")
    public String deleteOrder(@PathVariable int orderID, ModelMap modelMap){

        FilterList filterList = new FilterList();

        Orders order = orderRepo.findById(orderID).get();
        List<ClothesOrder> clothesOrderList = filterList.findClothesByOrderID(order, clothesOrderRepo.findAll());

        clothesOrderRepo.deleteAll(clothesOrderList);
        orderRepo.delete(order);

        modelMap.put("orders", orderRepo.findAll());

        return "orders";
    }

    @GetMapping("/deleteClothesOrder/{clothesOrderID}/{orderID}")
    public String deleteClothesOrder(@PathVariable int clothesOrderID, @PathVariable int orderID, ModelMap modelMap){

        ClothesOrder clothesOrder = clothesOrderRepo.findById(clothesOrderID).get();
        clothesOrderRepo.delete(clothesOrder);

        Orders order = orderRepo.findById(orderID).get();

        ClothesOrder newClothesOrder = new ClothesOrder();

        FilterList filterList = new FilterList();
        List<ClothesOrder> clothesOrderList = filterList.findClothesByOrderID(order, clothesOrderRepo.findAll());


        Set<String> setName = filterList.removeReplaysName(stockRepo.findAll());
        Set<String> setBrand = filterList.removeReplaysBrand(stockRepo.findAll());
        Set<String> setSize = filterList.removeReplaysSize(stockRepo.findAll());
        Set<String> setColor = filterList.removeReplaysColors(stockRepo.findAll());

        String sumPriceList = String.format("%.2f", newClothesOrder.sumPriceList(clothesOrderList));

        modelMap.put("newClothesOrder", clothesOrderList);
        modelMap.put("order", order);
        modelMap.put("name", setName);
        modelMap.put("brand", setBrand);
        modelMap.put("size", setSize);
        modelMap.put("color", setColor);
        modelMap.put("pricePrints", pricePrintsRepo.findAll());
        modelMap.put("sumPrice", newClothesOrder);
        modelMap.put("sumPriceList", sumPriceList);

        return "showClothesOrder";
    }

    @GetMapping("/filter")
    public String filterOrder(@RequestParam String filter, ModelMap modelMap){

        Orders orders = new FilterList().filterByNumberOrder(orderRepo.findAll(), filter);

        modelMap.put("orders", orders);

        return "orders";
    }
}
