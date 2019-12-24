package com.gg.unittesting.unittesting.spike;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


public class AssertJTest {

    @Test
    public void learning(){
        List<Integer> nums = Arrays.asList(12,10,20);

        assertThat(nums)
                .hasSize(3)
                .contains(12,10)
                .allMatch(x->x>0)
                .allMatch(x->x<100);

        assertThat("").isEmpty();

        assertThat("ABCDE")
                .contains("BCD")
                .endsWith("DE")
                .startsWith("AB");

        /*
        assertThat(nums, hasSize(3));
        assertThat(nums,hasItems(12,10));
        assertThat(nums, everyItem(greaterThan(0)));
        assertThat(nums, everyItem(lessThan(100)));

        assertThat("",emptyString());
        assertThat("ABC", containsString("BC"));
        assertThat("ABC", startsWith("A"));
        assertThat("ABC", endsWith("C"));
        */
    }
}
