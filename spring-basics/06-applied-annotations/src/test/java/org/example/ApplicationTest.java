package org.example;


import org.example.booking.Booking;
import org.example.booking.BookingService;
import org.example.booking.impl.BookingServiceImpl;
import org.junit.Test;
import org.springframework.beans.factory.BeanIsAbstractException;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.*;


public class ApplicationTest {

    /**
     * TODO: Excercise 2 - Simple annotation config with component scanning, please remove expected Exception
     */
    @Test (expected = NoSuchBeanDefinitionException.class)
    public void testCase1() throws Exception {
        ApplicationContext context = new ClassPathXmlApplicationContext("org/example/test-case1.xml");
        BookingService service = context.getBean("bookingServiceImpl", BookingServiceImpl.class);
        Booking booking = service.book("kacper", "101");

        assertNotNull(booking);
        assertEquals(booking.getPerson().getName(), "kacper");
        assertEquals(booking.getPerson().getAge(), 31);
        assertEquals(booking.getRoom().getRoomNumber(), "101");
    }
}
