package org.example;

import org.mockito.Mockito;
import org.testng.annotations.Test;

import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * User: chb
 */
public class MockTest {

    @Test
    public void testList() {

        List<String> mockedList = mock(List.class);
        when(mockedList.get(0)).thenReturn("test123");

        System.out.println(mockedList.get(0)); //test123
        System.out.println(mockedList.get(2)); //null

        verify(mockedList).get(0);
        verify(mockedList).get(2);
    }
}
