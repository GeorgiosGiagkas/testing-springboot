package com.gg.unittesting.unittesting.business;

import com.gg.unittesting.unittesting.data.StuffRepository;
import com.gg.unittesting.unittesting.model.Stuff;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StuffBusinessService {

    @Autowired
    StuffRepository stuffRepository;

    public List<Stuff> retrieveAllItems(){

        List<Stuff> stuffs  = stuffRepository.findAll();
        for(Stuff s:stuffs ){
            s.setValue(s.getPrice()*s.getQuantity());
        }
        return stuffs;
    }
}
