package com.gg.unittesting.unittesting.business;

import com.gg.unittesting.unittesting.data.SomeDataService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;



class SomeBusinessImplMockTest {

    SomeBusinessImpl business = new SomeBusinessImpl();
    SomeDataService mockService=mock(SomeDataService.class);


//    @Mock
//    SomeDataService mockService;
//    @InjectMocks
//    SomeBusinessImpl business ;


    @BeforeEach
    public void beforeEach(){
        business.setSomeDataService(mockService);
    }

    @Test
    public  void calculateSumUsingDataServiceBasic(){

        when(mockService.retrieveAllData()).thenReturn(new int[] {1,2,3});

        int actualResult = business.calculateSumUsingDataService();
        int expectedResult = 6;
        assertEquals(expectedResult,actualResult);
    }

    @Test
    public void calculateSumUsingDataServiceEmpty(){
        when(mockService.retrieveAllData()).thenReturn(new int[] {});
        int actualResult = business.calculateSumUsingDataService();
        int expectedResult = 0;
        assertEquals(expectedResult,actualResult);
    }
}