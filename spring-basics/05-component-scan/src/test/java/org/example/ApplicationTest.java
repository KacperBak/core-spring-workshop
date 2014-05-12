package org.example;


import org.junit.Test;
import org.example.case1.Booking;
import org.springframework.beans.factory.BeanDefinitionStoreException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.*;

/**
 * User: bakka
 * Date: 02.04.14
 */
public class ApplicationTest {

    /**
     * The bean id 'booking' is generated of the class name Booking.class
     * @throws Exception
     */
    @Test
    public void testGeneratedName() throws Exception {
        ApplicationContext context = new ClassPathXmlApplicationContext("org/example/test-case1.xml");
        Booking booking = context.getBean("booking", Booking.class);

        assertEquals(booking.getPerson().getName(), "micha");
        assertEquals(booking.getRoom().getRoomNumber(), "202");
    }

    /**
     * Ambiguous BookingDate is resolved by Qualifier 'utilDateImpl' that is generated of the class name UtilDateImpl.class
     * @throws Exception
     */
    @Test
    public void testDisambiguationByGeneratedName() throws Exception {
        ApplicationContext context = new ClassPathXmlApplicationContext("org/example/test-case2.xml");
        org.example.case2.Booking booking = context.getBean("booking", org.example.case2.Booking.class);

        assertEquals(booking.getPerson().getName(), "micha");
        assertEquals(booking.getRoom().getRoomNumber(), "202");
        assertTrue(booking.getBookingDate().getFormattedDate().contains("UtilDateImpl"));
    }

    /**
     * Ambiguous BookingDate is resolved by Qualifier 'myJoda' that is generated of the class name UtilDateImpl.class
     * @throws Exception
     */
    @Test
    public void testDisambiguationByComponentWithId() throws Exception {
        ApplicationContext context = new ClassPathXmlApplicationContext("org/example/test-case3.xml");
        org.example.case3.Booking booking = context.getBean("booking", org.example.case3.Booking.class);

        assertEquals(booking.getPerson().getName(), "micha");
        assertEquals(booking.getRoom().getRoomNumber(), "202");
        assertTrue(booking.getBookingDate().getFormattedDate().contains("JodaTimeImpl"));
    }

    /**
     * Include filter: Based on type
     * Looks for all classes that implements 'BookingDate' interface and handles them as managed beans
     * Ambiguous BookingDate is resolved by Qualifier 'utilDateImpl' that is generated of the class name UtilDateImpl.class
     * @throws Exception
     */
    @Test
    public void testIncludeFilterByType() throws Exception {
        ApplicationContext context = new ClassPathXmlApplicationContext("org/example/test-case4.xml");
        org.example.case4.Booking booking = context.getBean("booking", org.example.case4.Booking.class);

        assertEquals(booking.getPerson().getName(), "micha");
        assertEquals(booking.getRoom().getRoomNumber(), "202");
        assertTrue(booking.getBookingDate().getFormattedDate().contains("UtilDateImpl"));
    }

    /**
     * Include filter: Based on regex
     * No Qualifier needed, cause of clear regex
     * No @Component needed, cause of explicit include filter
     * @throws Exception
     */
    @Test
    public void testIncludeFilterByName() throws Exception {
        ApplicationContext context = new ClassPathXmlApplicationContext("org/example/test-case5.xml");
        org.example.case5.Booking booking = context.getBean("booking", org.example.case5.Booking.class);

        assertEquals(booking.getPerson().getName(), "micha");
        assertEquals(booking.getRoom().getRoomNumber(), "202");
        assertTrue(booking.getBookingDate().getFormattedDate().contains("JodaTimeImpl"));
    }

    /**
     * Exclude filter: Based on annotation Impl
     * No Qualifier needed, cause only ONE managed bean is left to be wired: utilDateImpl
     * @throws Exception
     */
    @Test
    public void testExcludeFilterByAnnotation() throws Exception {
        ApplicationContext context = new ClassPathXmlApplicationContext("org/example/test-case6.xml");
        org.example.case6.Booking booking = context.getBean("booking", org.example.case6.Booking.class);

        assertEquals(booking.getPerson().getName(), "micha");
        assertEquals(booking.getRoom().getRoomNumber(), "202");
        assertTrue(booking.getBookingDate().getFormattedDate().contains("UtilDateImpl"));
    }

    /**
     * Conflict with bean definition of same name and class 'Booking'
     * Caused by scanning 'org.example'
     * @throws BeanDefinitionStoreException, ConflictingBeanDefinitionException
     */
    @Test(expected = BeanDefinitionStoreException.class)
    public void testConflictWithBeanDefinitionOfSameName() throws Exception {
        ApplicationContext context = new ClassPathXmlApplicationContext("org/example/test-case7.xml");
        org.example.case7.Booking booking = context.getBean("booking", org.example.case7.Booking.class);

        assertEquals(booking.getPerson().getName(), "micha");
        assertEquals(booking.getRoom().getRoomNumber(), "202");
    }
}
