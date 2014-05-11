package org.example;


import org.example.booking.Booking;
import org.example.booking.BookingService;
import org.example.booking.impl.BookingServiceImpl;
import org.junit.Test;
import org.springframework.beans.factory.BeanIsAbstractException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.*;


public class ApplicationTest {

    /**
     * Simple bean wiring
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
     * Optional dependencies can cause NullPointerException
     * @throws java.lang.NullPointerException
     */
    @Test (expected = NullPointerException.class)
    public void testCase3() throws NullPointerException {
        ApplicationContext context = new ClassPathXmlApplicationContext("org/example/test-case3.xml");
        BookingService service = context.getBean("bookingService", BookingServiceImpl.class);
        Booking booking = service.book("bob", "101");

        assertNotNull(booking);
        assertEquals(booking.getPerson().getName(), "bob");
        assertEquals(booking.getPerson().getAge(), 25);
        assertEquals(booking.getRoom().getRoomNumber(), "101");

        //NullPointerException
        booking.toString();
    }

    /**
     * Setting JodaTimeImpl via property, as optional dependency
     * @throws Exception
     */
    @Test
    public void testCase4() throws Exception {
        ApplicationContext context = new ClassPathXmlApplicationContext("org/example/test-case4.xml");
        BookingService service = context.getBean("bookingService", BookingServiceImpl.class);
        Booking booking = service.book("bob", "101");

        assertNotNull(booking);
        assertTrue(booking.toString().contains("JodaTimeImpl"));
    }

    /**
     * Bean inheritance
     * @throws BeanIsAbstractException
     */
    @Test (expected = BeanIsAbstractException.class)
    public void testCase5() throws BeanIsAbstractException {
        ApplicationContext context = new ClassPathXmlApplicationContext("org/example/test-case5.xml");

        //get jodaBookingService bean
        BookingService service = context.getBean("jodaBookingService", BookingServiceImpl.class);
        Booking booking = service.book("kacper", "101");
        assertNotNull(booking);
        assertTrue(booking.toString().contains("JodaTimeImpl"));

        //get utilBookingService bean
        service = context.getBean("utilBookingService", BookingServiceImpl.class);
        booking = service.book("micha", "101");
        assertNotNull(booking);
        assertTrue(booking.toString().contains("UtilDateImpl"));

        //Instantiating abstract bean fails with BeanIsAbstractException
        service = context.getBean("bookingService", BookingServiceImpl.class);
    }
}
