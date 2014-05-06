package org.example.person;

/**
 * User: bakka
 */
public interface PersonRepository {

    Person findPersonByName(String name);
}
