package de.kacperbak;


import de.kacperbak.booking.BookingService;
import de.kacperbak.booking.impl.BookingServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Application {

    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("de/kacperbak/spring-conf.xml", "de/kacperbak/spring-beans.xml");
        BookingService service = context.getBean("bookingService", BookingServiceImpl.class);
        System.out.println(service.book("kacper", "101"));

    }
}

