package com.gg.unittesting.unittesting.business;

import com.gg.unittesting.unittesting.data.SomeDataService;
import lombok.NoArgsConstructor;
import lombok.Setter;




@NoArgsConstructor
public class SomeBusinessImpl {

    @Setter
    private SomeDataService someDataService;


    public int calculateSum(int []data){
        int sum=0;
        for(int i : data){
            sum+=i;
        }
        return  sum;
    }

    public int calculateSumUsingDataService(){
        int sum=0;
        int [] data = someDataService.retrieveAllData();
        for(int i : data){
            sum+=i;
        }
        return  sum;
    }
}
