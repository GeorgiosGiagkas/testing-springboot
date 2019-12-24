package com.gg.unittesting.unittesting.controllers;

import com.gg.unittesting.unittesting.business.StuffBusinessService;
import com.gg.unittesting.unittesting.model.Stuff;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@WebMvcTest(StuffController.class)
class StuffControllerTest {

    @MockBean
    StuffBusinessService stuffBusinessService;

    @Autowired
    MockMvc mockMvc;

    @Test
    public void retrieveAllStuffBasic() throws Exception {

        when(stuffBusinessService.retrieveAllItems()).thenReturn(
                Arrays.asList(new Stuff(1,"Stuff1",10,20),
                        new Stuff(2,"Stuff2",10,200))
        );

        //create request
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/all-stuff-from-database")
                .accept(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder)
                .andExpect(status().isOk())
                .andExpect(content().json("[{id:1,name:Stuff1,price:10,quantity:20},{}]"))
                .andReturn();


    }
}