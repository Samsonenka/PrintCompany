package com.samson.printCompany.controllers;

import com.samson.printCompany.logics.FilterList;
import com.samson.printCompany.models.Arrival;
import com.samson.printCompany.repos.ArrivalRepo;
import com.samson.printCompany.repos.ClothesRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Collections;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/history/")
public class HistoryController {

    @Autowired
    ArrivalRepo arrivalRepo;

    @Autowired
    ClothesRepo clothesRepo;

    @GetMapping("/showAll")
    public String showHistory(ModelMap modelMap){

        List<Arrival> arrivalList = arrivalRepo.findAll();
        Collections.reverse(arrivalList);

        modelMap.put("history", arrivalList);

        return "history";
    }

    @GetMapping("/filter")
    public String filterHistory(@RequestParam("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date date, ModelMap modelMap){

        FilterList filterList = new FilterList();
        List<Arrival> arrivalList = filterList.filterListByDate(arrivalRepo.findAll(), date);

        modelMap.put("history", arrivalList);

        return "history";
    }
}
