package de.kacperbak;


import de.kacperbak.booking.Booking;
import de.kacperbak.booking.BookingService;
import de.kacperbak.booking.impl.BookingServiceImpl;
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
        ApplicationContext context = new ClassPathXmlApplicationContext("de/kacperbak/test-case1.xml");
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
        ApplicationContext context = new ClassPathXmlApplicationContext("de/kacperbak/test-case2.xml");
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
//        ApplicationContext context = new ClassPathXmlApplicationContext("de/kacperbak/test-case3*");
        ApplicationContext context = new ClassPathXmlApplicationContext("de/kacperbak/test-case3-conf.xml", "de/kacperbak/test-case3-beans.xml");
        BookingService service = context.getBean("bookingService", BookingServiceImpl.class);
        Booking booking = service.book("bob", "101");

        assertNotNull(booking);
        assertEquals(booking.getPerson().getName(), "bob");
        assertEquals(booking.getPerson().getAge(), 25);
        assertEquals(booking.getRoom().getRoomNumber(), "101");
    }


}
