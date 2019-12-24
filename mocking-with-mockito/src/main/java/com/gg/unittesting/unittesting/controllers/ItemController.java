package com.gg.unittesting.unittesting.controllers;

import com.gg.unittesting.unittesting.business.ItemBusinessService;
import com.gg.unittesting.unittesting.model.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ItemController {

    @Autowired
    private ItemBusinessService itemBusinessService;

    @GetMapping("/dummy-item")
    public Item getItem(){
        Item item = new Item.ItemBuilder(1)
                .createName("Ball")
                .definePrice(10)
                .defineQuantity(100)
                .build();
        return  item;
    }

    @GetMapping("/item-from-business-service")
    public Item getItemFromBusiness(){
        return itemBusinessService.retrieveHardCodedItem();
    }
}
