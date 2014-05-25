package org.example.orm.api;

import org.example.orm.model.Person;

import java.util.List;

/**
 * User: chb
 */
public interface PersonRepository {

    public Person findById(Long id);

    public List<Person> findAllByFirstName(String firstName);

    public List<Person> findAllByLastName(String lastName);

    public List<Person> findAllPersonsOlderThan(int age);

    public void addPerson(Person person);

}
