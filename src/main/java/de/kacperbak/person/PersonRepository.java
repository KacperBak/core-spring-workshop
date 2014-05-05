package de.kacperbak.person;

/**
 * User: bakka
 */
public interface PersonRepository {

    Person findPersonByName(String name);
}
