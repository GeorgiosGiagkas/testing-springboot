package com.gg.unittesting.unittesting.spike;

import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

public class JsonAssertTest {

    @Test
    public void jsonAssertStrictTrue() throws JSONException {
        String actual = "{\"id\":1,\"name\":\"Ball\",\"price\":10,\"quantity\":100}";
        String expected ="{\"id\":1,\"name\":\"Ball\",\"price\":10,\"quantity\":100}";
        JSONAssert.assertEquals(expected,actual,true);
    }

    @Test
    public  void jsonAssertStrictFalse() throws JSONException{
        String actual = "{\"id\":1,\"name\":\"Ball\",\"price\":10,\"quantity\":100}";
        String expected ="{\"id\":1,\"name\":\"Ball\",\"price\":10}";
        JSONAssert.assertEquals(expected,actual,false);
    }

    @Test
    public void jsonAssertStricFalseAndWithoutEscapeChars() throws  JSONException{
        String actual = "{id:1,name:Ball,price:10,quantity:100}";
        String expected = "{id:1,name:Ball,price:10}";
        JSONAssert.assertEquals(expected,actual,false);
    }
}
