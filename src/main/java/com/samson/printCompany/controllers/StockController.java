package com.samson.printCompany.controllers;

import com.samson.printCompany.logics.FilterList;
import com.samson.printCompany.models.History;
import com.samson.printCompany.models.Stock;
import com.samson.printCompany.models.enums.Status;
import com.samson.printCompany.repos.StockRepo;
import com.samson.printCompany.repos.HistoryRepo;
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
    private StockRepo stockRepo;
    @Autowired
    private HistoryRepo historyRepo;

    @GetMapping("/showAll")
    public String showClothes(ModelMap modelMap){

        modelMap.put("clothes", stockRepo.findAll());

        return "stock";
    }

    @PostMapping("/add")
    public String addClothes(@RequestParam String clothesName, @RequestParam String clothesBrand,
                             @RequestParam String clothesSize, @RequestParam String clothesColor,
                             @RequestParam int clothesQuantity, ModelMap modelMap){

        Stock stock = new Stock(clothesName, clothesBrand, clothesSize, clothesColor, clothesQuantity);

        Stock newClothes = stock.addClothes(stockRepo.findAll());
        History history = new History(stock, Status.arrival.toString());

        historyRepo.save(history);
        stockRepo.save(newClothes);

        List<Stock> stockList = stockRepo.findAll();
        Collections.reverse(stockList);

        modelMap.put("clothes", stockList);

        return "stock";
    }

    @GetMapping("/filter")
    public String filterClothes(@RequestParam String filter, ModelMap modelMap){

        FilterList filterList = new FilterList();
        List<Stock> stockList = filterList.filterByStock(stockRepo.findAll(), filter);

        modelMap.put("clothes", stockList);

        return "stock";
    }


}
