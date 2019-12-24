package com.gg.unittesting.unittesting.spike;


import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;


import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class HamcrestMatchersTest {

    @Test
    public void learning(){
        List<Integer> nums = Arrays.asList(12,10,20);
        assertThat(nums, hasSize(3));
        assertThat(nums,hasItems(12,10));
        assertThat(nums, everyItem(greaterThan(0)));
        assertThat(nums, everyItem(lessThan(100)));

        assertThat("",emptyString());
        assertThat("ABC", containsString("BC"));
        assertThat("ABC", startsWith("A"));
        assertThat("ABC", endsWith("C"));
    }
}
