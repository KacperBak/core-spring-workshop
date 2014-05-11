package org.example;


import junit.framework.Assert;
import org.example.booking.Booking;
import org.example.booking.BookingService;
import org.example.booking.impl.BookingServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Application {

    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("org/example/spring.xml");
        BookingService service1 = context.getBean("bookingService", BookingServiceImpl.class);

        Booking booking = service1.book("kacper", "101");

        System.out.println("name: " + booking.getPerson().getName());
        System.out.println("age: " + booking.getPerson().getAge());
        System.out.println("roomNr: " + booking.getRoom().getRoomNumber());

        //Nullpointer, cause of not set optional dependency
//        System.out.println(booking);
    }
}

