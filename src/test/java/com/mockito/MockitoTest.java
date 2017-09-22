package com.mockito;

/**
 * Created by IntelliJ IDEA.
 * User: luohuahua
 * Date: 2017/9/13
 * Time: 10:51  .
 */

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

import static org.mockito.Mockito.*;

public class MockitoTest {

    public static void main(String[] args) {
        // mock creation
        List mockedList = mock(List.class);

        // using mock object - it does not throw any "unexpected interaction" exception
        mockedList.add("one");
        mockedList.clear();

        // selective, explicit, highly readable verification
        verify(mockedList).add("one");
        verify(mockedList).clear();
    }

    @Test
    public void testwhenMock() {
        // you can mock concrete classes, not only interfaces
        LinkedList mockedList = mock(LinkedList.class);
        // stubbing appears before the actual execution
        when(mockedList.get(0)).thenReturn("first");

        when(mockedList.size()).thenThrow(new Exception("unsupport method"));
        // the following prints "first"
        System.out.println(mockedList.get(0));

        // the following prints "null" because get(999) was not stubbed
        System.out.println(mockedList.get(999));

        System.out.println(mockedList.size());
    }

    @Test
    public void testverifyMock(){
        LinkedList mockedList = mock(LinkedList.class);
        mockedList.get(0);
        verify(mockedList).get(0);
    }
}
