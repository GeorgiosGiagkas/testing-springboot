package com.gg.unittesting.unittesting.business;
import org.junit.Test;
import org.mockito.ArgumentCaptor;

import java.util.ArrayList;
import java.util.List;

import static  org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;


public class ListMockTest {
    List<String> mockList  = mock(List.class);

    @Test
    public void sizeBasic(){
        when(mockList.size()).thenReturn(5);
        assertEquals(5, mockList.size());
    }

    @Test
    public void multipleValues(){
        when(mockList.size()).thenReturn(5).thenReturn(10);
        assertEquals(5, mockList.size());
        assertEquals(10, mockList.size());
    }

    @Test
    public void returnWithParams(){
        when(mockList.get(0)).thenReturn("0 index");
        assertEquals("0 index",mockList.get(0));
    }

    @Test
    public void returnWithGenericParams(){
        when(mockList.get(anyInt())).thenReturn("Any int");
        assertEquals("Any int",mockList.get(5));
        assertEquals("Any int",mockList.get(10));
    }

    @Test
    public void verificationBasics(){
        String value1 = mockList.get(0);
        String value2 = mockList.get(1);

        verify(mockList).get(0);
        verify(mockList).get(1);
        verify(mockList, times(2)).get(anyInt());

        verify(mockList, atLeast(1)).get(anyInt());
        verify(mockList, atMost(2)).get(anyInt());
        verify(mockList, never()).get(2);
    }

    @Test
    public void argumentCapturing(){
        mockList.add("My String");

        ArgumentCaptor<String> stringCaptor = ArgumentCaptor.forClass(String.class);

        verify(mockList).add(stringCaptor.capture());

        assertEquals("My String",stringCaptor.getValue());
    }

    @Test
    public void multipleArgsCapturing(){
        mockList.add("My String 1");
        mockList.add("My String 2");

        ArgumentCaptor<String> stringCaptor = ArgumentCaptor.forClass(String.class);
        verify(mockList, times(2)).add(stringCaptor.capture());
        List<String> values = stringCaptor.getAllValues();
        assertEquals("My String 1",values.get(0));
        assertEquals("My String 2", values.get(1));
    }

    @Test
    public void mocking(){
        ArrayList<String> arrayMock = mock(ArrayList.class);
        arrayMock.get(0);//null
        arrayMock.size();//0
        arrayMock.add("Test1");
        arrayMock.add("Test2");
        arrayMock.size();//0
        when(arrayMock.size()).thenReturn(5);
        arrayMock.size();//5
    }

    @Test
    public void spying(){
        ArrayList<String> arrayMock = mock(ArrayList.class);
        arrayMock.add("Test1");
        arrayMock.add("Test2");
        arrayMock.get(0);//test1
        arrayMock.size();//2

        when(arrayMock.size()).thenReturn(5);
        arrayMock.size();//5
    }
}
