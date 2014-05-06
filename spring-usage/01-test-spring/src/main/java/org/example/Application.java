package org.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Application {

    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("org/example/spring.xml");
        Person person = context.getBean("chris", Person.class);
        System.out.println(person);
    }
}
