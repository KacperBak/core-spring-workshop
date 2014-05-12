package org.example;

import org.example.case4.Booking;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Application {

    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("org/example/spring.xml");
        Booking booking = context.getBean("booking", Booking.class);
        System.out.println(booking.toString());

        //at least, take a general namespace like org.example to get a conflict bean definition exception 'ConflictingBeanDefinitionException'
    }
}

