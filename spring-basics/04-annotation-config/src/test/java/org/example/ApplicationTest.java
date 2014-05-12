package org.example;

import org.junit.Test;
import org.example.domain.injection.method.Booking;
import org.springframework.beans.factory.UnsatisfiedDependencyException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * User: bakka
 * Date: 02.04.14
 */
public class ApplicationTest {

    @Test
    public void testMethodInjection() throws Exception {
        ApplicationContext context = new ClassPathXmlApplicationContext("org/example/test-methodInjection.xml");
        Booking booking = context.getBean("booking", Booking.class);

        assertEquals(booking.getPerson().getName(), "micha");
        assertEquals(booking.getRoom(), null);
    }

    @Test
    public void testFieldInjection() throws Exception {
        ApplicationContext context = new ClassPathXmlApplicationContext("org/example/test-fieldInjection.xml");
        org.example.domain.injection.field.Booking booking = context.getBean("booking", org.example.domain.injection.field.Booking.class);

        assertEquals(booking.getPerson().getName(), "kacper");
        assertEquals(booking.getRoom().getRoomNumber(), "101");
    }

    @Test
    public void testCtorInjection() throws Exception {
        ApplicationContext context = new ClassPathXmlApplicationContext("org/example/test-ctorInjection.xml");
        org.example.domain.injection.ctor.Booking booking = context.getBean("booking", org.example.domain.injection.ctor.Booking.class);

        assertEquals(booking.getPerson().getName(), "micha");
        assertEquals(booking.getRoom().getRoomNumber(), "202");
    }

    /**
     * UnsatisfiedDependencyException followed by a NoUniqueBeanDefinitionException
     * Reason: JodaTimeStub and UtilDateStub are BOTH annotated with same @Qualifier("static") and ctor does NOT distinguish further
     * @throws Exception
     */
    @Test(expected = UnsatisfiedDependencyException.class)
    public void testCase1st() throws Exception {
        ApplicationContext context = new ClassPathXmlApplicationContext("org/example/test-case1st.xml");
    }

    @Test
    public void testCase2nd() throws Exception {
        ApplicationContext context = new ClassPathXmlApplicationContext("org/example/test-case2nd.xml");
        org.example.domain.wiring.case2nd.Booking booking = context.getBean("booking", org.example.domain.wiring.case2nd.Booking.class);
        assertTrue(booking.getBookingDate().getFormattedDate().contains("JodaTimeStub"));
    }

    @Test
    public void testCase3rd() throws Exception {
        ApplicationContext context = new ClassPathXmlApplicationContext("org/example/test-case3rd.xml");
        org.example.domain.wiring.case3rd.Booking booking = context.getBean("booking", org.example.domain.wiring.case3rd.Booking.class);
        assertTrue(booking.getBookingDate().getFormattedDate().contains("UtilDateImpl"));
    }

    @Test
    public void testCase4th() throws Exception {
        ApplicationContext context = new ClassPathXmlApplicationContext("org/example/test-case4th.xml");
        org.example.domain.wiring.case4th.Booking booking = context.getBean("booking", org.example.domain.wiring.case4th.Booking.class);
        assertTrue(booking.getBookingDate().getFormattedDate().contains("JodaTimeImpl"));
    }

    @Test
    public void testCase5th() throws Exception {
        ApplicationContext context = new ClassPathXmlApplicationContext("org/example/test-case5th.xml");
        org.example.domain.wiring.case5th.Booking booking = context.getBean("booking", org.example.domain.wiring.case5th.Booking.class);
        assertTrue(booking.getBookingDate().getFormattedDate().contains("UtilDateStub"));
    }
}
