package org.example;


import org.example.booking.BookingService;
import org.example.booking.impl.BookingServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Application {

    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("org/example/spring-conf.xml", "org/example/spring-beans.xml");
        BookingService service = context.getBean("bookingService", BookingServiceImpl.class);
        System.out.println(service.book("kacper", "101"));

    }
}

