package com.gg.unittesting.unittesting.business;


import com.gg.unittesting.unittesting.model.Item;
import org.springframework.stereotype.Component;

@Component
public class ItemBusinessService {

    public Item retrieveHardCodedItem(){
        Item item = new Item.ItemBuilder(1)
                .createName("Ball")
                .definePrice(10)
                .defineQuantity(100)
                .build();
        return  item;
    }
}
