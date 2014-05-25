package org.example;


import org.example.case2.impl.BookingServiceImplJodaTime;
import org.example.case2.impl.BookingServiceImplUtilDate;
import org.example.case3.BookingDate;
import org.example.case3.impl.BookingServiceImpl;
import org.example.case3.impl.JodaTimeImpl;
import org.example.case3.impl.UtilDateImpl;
import org.example.case4.BookingService;
import org.example.case4.ServiceFactory;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.*;


public class ApplicationTest {

    @Test
    public void testCase1() throws Exception {

        org.example.case1.BookingService utilService = new org.example.case1.impl.BookingServiceImpl();
        org.example.case1.BookingService jodaService = new org.example.case1.impl.BookingServiceImpl(){
            @Override
            public String displayBooking() {
                String result = "Booking SUCCEED on " + new org.example.case1.impl.JodaTimeImpl().getFormattedDate();
                System.out.println(result);
                return result;
            }
        };

        assertTrue(utilService.displayBooking().contains("UtilDateImpl"));
        assertTrue(jodaService.displayBooking().contains("JodaTimeImpl"));
    }

    @Test
    public void testCase2() throws Exception {

        org.example.case2.BookingService utilService = new BookingServiceImplUtilDate();
        org.example.case2.BookingService jodaService = new BookingServiceImplJodaTime();

        assertTrue(utilService.displayBooking().contains("UtilDateImpl"));
        assertTrue(jodaService.displayBooking().contains("JodaTimeImpl"));
    }

    @Test
    public void testCase3() throws Exception {

       BookingDate utilDate = new UtilDateImpl();
       BookingDate jodaDate = new JodaTimeImpl();
       org.example.case3.BookingService utilService = new BookingServiceImpl(utilDate);
       org.example.case3.BookingService jodaService = new BookingServiceImpl(jodaDate);

       assertTrue(utilService.displayBooking().contains("UtilDateImpl"));
       assertTrue(jodaService.displayBooking().contains("JodaTimeImpl"));
    }

    @Test
    public void testCase4() throws Exception {

        BookingService utilService = new ServiceFactory<org.example.case4.impl.UtilDateImpl>(org.example.case4.impl.UtilDateImpl.class).createService();
        BookingService jodaService = new ServiceFactory<org.example.case4.impl.JodaTimeImpl>(org.example.case4.impl.JodaTimeImpl.class).createService();

        assertTrue(utilService.displayBooking().contains("UtilDateImpl"));
        assertTrue(jodaService.displayBooking().contains("JodaTimeImpl"));
    }

    @Test
    public void testCase5() throws Exception {

        ApplicationContext context = new ClassPathXmlApplicationContext("org/example/test-case5.xml");

        assertTrue(context.getBean("utilService", org.example.case5.impl.BookingServiceImpl.class).displayBooking().contains("UtilDateImpl"));
        assertTrue(context.getBean("jodaService", org.example.case5.impl.BookingServiceImpl.class).displayBooking().contains("JodaTimeImpl"));
    }
}
