package org.example;


import org.example.booking.Booking;
import org.example.booking.BookingService;
import org.example.booking.impl.BookingServiceImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.*;


public class ApplicationTest {

    /**
     * Bean wiring
     * @throws Exception
     */
    @Test
    public void testCase1() throws Exception {
        ApplicationContext context = new ClassPathXmlApplicationContext("org/example/test-case1.xml");
        BookingService service = context.getBean("bookingService", BookingServiceImpl.class);
        Booking booking = service.book("kacper", "101");

        assertNotNull(booking);
        assertEquals(booking.getPerson().getName(), "kacper");
        assertEquals(booking.getPerson().getAge(), 31);
        assertEquals(booking.getRoom().getRoomNumber(), "101");
    }

    /**
     * Using property placeholder
     * @throws Exception
     */
    @Test
    public void testCase2() throws Exception {
        ApplicationContext context = new ClassPathXmlApplicationContext("org/example/test-case2.xml");
        BookingService service = context.getBean("bookingService", BookingServiceImpl.class);
        Booking booking = service.book("bob", "101");

        assertNotNull(booking);
        assertEquals(booking.getPerson().getName(), "bob");
        assertEquals(booking.getPerson().getAge(), 25);
        assertEquals(booking.getRoom().getRoomNumber(), "101");
    }

    /**
     * Bootstrapping spring files: Separate bean definition from configuration
     * @throws Exception
     */
    @Test
    public void testCase3() throws Exception {
//        ApplicationContext context = new ClassPathXmlApplicationContext("org/example/test-case3*");
        ApplicationContext context = new ClassPathXmlApplicationContext("org/example/test-case3-conf.xml", "org/example/test-case3-beans.xml");
        BookingService service = context.getBean("bookingService", BookingServiceImpl.class);
        Booking booking = service.book("bob", "101");

        assertNotNull(booking);
        assertEquals(booking.getPerson().getName(), "bob");
        assertEquals(booking.getPerson().getAge(), 25);
        assertEquals(booking.getRoom().getRoomNumber(), "101");
    }


}
