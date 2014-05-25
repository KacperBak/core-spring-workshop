package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * User: chb
 */
@ContextConfiguration(locations = {"classpath:org/example/spring.xml"})
public class SpringIntegrationTest extends AbstractTestNGSpringContextTests{

    @Autowired
    private Person person;

    @Test
    public void testPerson() throws Exception {
        assertEquals(person.getAge(), 27);
    }
}
