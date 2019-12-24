package com.gg.unittesting.unittesting.business;

import com.gg.unittesting.unittesting.data.SomeDataService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SomeBusinessServiceStubBasic implements SomeDataService{

    @Override
    public int[] retrieveAllData() {
        return new int[]{1,2,3};
    }
}

class SomeBusinessServiceStubEmpty implements SomeDataService{

    @Override
    public int[] retrieveAllData() {
        return new int[] {};
    }
}

class SomeBusinessImplStubTest {

    @Test
    public  void calculateSumUsingDataServiceBasic(){
        SomeBusinessImpl business = new SomeBusinessImpl();
        business.setSomeDataService(new SomeBusinessServiceStubBasic());
        int actualResult = business.calculateSumUsingDataService();
        int expectedResult = 6;
        assertEquals(expectedResult,actualResult);
    }

    @Test
    public void calculateSumUsingDataServiceEmpty(){
        SomeBusinessImpl business = new SomeBusinessImpl();
        business.setSomeDataService(new SomeBusinessServiceStubEmpty());
        int actualResult = business.calculateSumUsingDataService();
        int expectedResult = 0;
        assertEquals(expectedResult,actualResult);
    }
}