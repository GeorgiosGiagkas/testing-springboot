package com.gg.unittesting.unittesting.spike;

import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class JsonPathTest {
    
    @Test
    public void learning(){
        String responseFromService=
                        "[{\"id\":1,\"name\":\"Pencil\",\"quantity\":15}," +
                        "{\"id\":2,\"name\":\"Pen\",\"quantity\":15}," +
                        "{\"id\":3,\"name\":\"Eraser\",\"quantity\":10}]" ;


        DocumentContext context=JsonPath.parse(responseFromService);

        int length= context.read("$.length()");//from root
        assertThat(length).isEqualTo(3);

        List<Integer> ids = context.read("$..id");
        assertThat(ids).containsExactly(1,2,3);

        List<String> names = context.read("$..name");
        assertThat(names).contains("Pen");

        String eraser=context.read("$.[?(@.name=='Eraser')]").toString();
        assertThat(eraser).isEqualTo("[{\"id\":3,\"name\":\"Eraser\",\"quantity\":10}]");

    }
}
