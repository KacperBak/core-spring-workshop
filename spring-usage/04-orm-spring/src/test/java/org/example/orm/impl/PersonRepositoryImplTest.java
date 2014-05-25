package org.example.orm.impl;

import org.example.orm.api.PersonRepository;
import org.example.orm.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertEquals;


/**
 * User: chb
 */
@ContextConfiguration(locations = {"classpath:org/example/orm/spring-config.xml"})
public class PersonRepositoryImplTest extends AbstractTestNGSpringContextTests{

    @Autowired
    private PersonRepository personRepository;

    @Test
    public void testInsertPersons() {
        Person person = new Person("Christian", "Böhme", 27);
        personRepository.addPerson(person);

        List<Person> persons = personRepository.findAllByFirstName("Christian");
        assertEquals(persons.size(), 1);


    }
}
