package com.samson.printCompany.controllers;

import com.samson.printCompany.logics.FilterList;
import com.samson.printCompany.models.History;
import com.samson.printCompany.repos.ClothesRepo;
import com.samson.printCompany.repos.HistoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

@Controller
@RequestMapping("/history/")
public class HistoryController {

    @Autowired
    private HistoryRepo historyRepo;

    @GetMapping("/showAll")
    public String showHistory(ModelMap modelMap){

        List<History> arrivalList = historyRepo.findAll();
        Collections.reverse(arrivalList);

        modelMap.put("history", arrivalList);

        return "history";
    }

    @GetMapping("/filter")
    public String filterHistory(@RequestParam("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date, ModelMap modelMap){

        FilterList filterList = new FilterList();
        List<History> arrivalList = filterList.filterListByDate(historyRepo.findAll(), date);

        modelMap.put("history", arrivalList);

        return "history";
    }
}
