package org.example;


import org.example.case5.impl.BookingServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Application {

    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("de/kacperbak/spring.xml");

        context.getBean("jodaService", BookingServiceImpl.class).displayBooking();
    }
}

