package org.example;


import org.example.case5.BookingService;
import org.example.case5.impl.BookingServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Application {

    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("de/kacperbak/spring.xml");

        BookingService service = context.getBean("jodaService", BookingServiceImpl.class);

        service.displayBooking();
    }
}

