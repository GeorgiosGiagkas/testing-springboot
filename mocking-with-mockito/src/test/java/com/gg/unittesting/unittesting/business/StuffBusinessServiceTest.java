package com.gg.unittesting.unittesting.business;

import com.gg.unittesting.unittesting.data.StuffRepository;
import com.gg.unittesting.unittesting.model.Stuff;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;



import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;


class StuffBusinessServiceTest {

    @Mock
    private StuffRepository stuffRepository;
    @InjectMocks
    private StuffBusinessService stuffBusinessService;

    @BeforeEach
    public void init(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void retrieveAllTest(){
        when(stuffRepository.findAll()).thenReturn(
                Arrays.asList(new Stuff(1,"Stuff1",10,20),
                        new Stuff(2,"Stuff2",10,200))
        );

        List<Stuff> stuffs=stuffBusinessService.retrieveAllItems();
        assertEquals(200,stuffs.get(0).getValue());
        assertEquals(2000,stuffs.get(1).getValue());
    }
}