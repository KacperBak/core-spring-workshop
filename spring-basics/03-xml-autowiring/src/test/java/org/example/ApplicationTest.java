package org.example;

import org.example.domain.Booking;
import org.junit.Test;
import org.springframework.beans.factory.UnsatisfiedDependencyException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.assertEquals;

/**
 * User: bakka
 * Date: 02.04.14
 */
public class ApplicationTest {

    @Test
    public void testByName() throws Exception {
        ApplicationContext context = new ClassPathXmlApplicationContext("org/example/test-injectionByName.xml");
        Booking byName1 = context.getBean("byName1", Booking.class);
        Booking byName2 = context.getBean("byName2", Booking.class);
        Booking byName3 = context.getBean("byName3", Booking.class);

        //same person wired
        assertEquals(byName1.getPerson().getName(), byName2.getPerson().getName());

        //explicit override
        assertEquals(byName3.getPerson().getName(), "micha");
    }

    /**
     * UnsatisfiedDependencyException, NoUniqueBeanDefinitionException
     * @throws Exception
     */
    @Test(expected = UnsatisfiedDependencyException.class)
    public void testByTypeNoUniqueBean() throws Exception {
        ApplicationContext context = new ClassPathXmlApplicationContext("org/example/test-injectionByType-noUniqueBean.xml");
    }

    @Test
    public void testByTypePrimary() throws Exception {
        ApplicationContext context = new ClassPathXmlApplicationContext("org/example/test-injectionByType-primary.xml");
        Booking byType = context.getBean("byType1", Booking.class);
        assertEquals(byType.getPerson().getName(), "micha");
    }

    @Test
    public void testByTypeAutowireCandidate() throws Exception {
        ApplicationContext context = new ClassPathXmlApplicationContext("org/example/test-injectionByType-autowire-candidate.xml");
        Booking byType = context.getBean("byType1", Booking.class);
        assertEquals(byType.getPerson().getName(), "kacper");
    }

    @Test
    public void testByConstructor() throws Exception {
        ApplicationContext context = new ClassPathXmlApplicationContext("org/example/test-injectionByConstructor.xml");
        Booking byConstructorDefault = context.getBean("byConstructorDefault", Booking.class);
        assertEquals(byConstructorDefault.getPerson().getName(), "kacper");
        assertEquals(byConstructorDefault.getRoom().getRoomNumber(), "101");

        Booking byConstructorOverrideWithBeans = context.getBean("byConstructorOverrideWithBeans", Booking.class);
        assertEquals(byConstructorOverrideWithBeans.getPerson().getName(), "micha");
        assertEquals(byConstructorOverrideWithBeans.getRoom().getRoomNumber(), "202");

        Booking byConstructorOverrideWithNull = context.getBean("byConstructorOverrideWithNull", Booking.class);
        assertEquals(byConstructorOverrideWithNull.getPerson(), null);
        assertEquals(byConstructorOverrideWithNull.getRoom(), null);
    }

    @Test
    public void testByRoot() throws Exception {
        ApplicationContext context = new ClassPathXmlApplicationContext("org/example/test-injectionByConstructorRoot.xml");
        Booking byConstructorDefault = context.getBean("byRootDefault", Booking.class);
        assertEquals(byConstructorDefault.getPerson().getName(), "micha");
        assertEquals(byConstructorDefault.getRoom().getRoomNumber(), "101");

        Booking byConstructorOverrideWithBeans = context.getBean("byRootDefaultOverride", Booking.class);
        assertEquals(byConstructorOverrideWithBeans.getPerson().getName(), "kacper");
        assertEquals(byConstructorOverrideWithBeans.getRoom().getRoomNumber(), "202");
    }
}
