package com.gg.unittesting.unittesting.controllers;

import com.gg.unittesting.unittesting.business.StuffBusinessService;
import com.gg.unittesting.unittesting.model.Stuff;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StuffController {

    @Autowired
    StuffBusinessService stuffBusinessService;

    @GetMapping("/all-stuff-from-database")
    public List<Stuff> retrieveAllStuff(){
        return stuffBusinessService.retrieveAllItems();
    }
}
