package org.example.person.impl;

import org.example.person.Person;
import org.example.person.PersonRepository;
import org.example.room.impl.HashMapRoomRepositoryImpl;

import java.util.HashMap;
import java.util.Map;

/**
 * User: bakka
 */
public class SingletonHashMapPersonRepositoryImpl implements PersonRepository{

    private Map<String, Person> personMap;

    private final static SingletonHashMapPersonRepositoryImpl instance = new SingletonHashMapPersonRepositoryImpl();

    /**
     * Not accessible private ctor
     */
    private SingletonHashMapPersonRepositoryImpl(){
        this.personMap = createInitialPersons();
    }

    /**
     * Retrives the refrence of the singleton instance
     * @return
     */
    public static SingletonHashMapPersonRepositoryImpl getInstance() {
        return instance;
    }

    private Map<String, Person> createInitialPersons(){
        Map<String, Person> testMap = new HashMap<String, Person>();
        testMap.put("test", new Person("test", 0));
        return testMap;
    }

    @Override
    public Person findPersonByName(String name) {
        return personMap.get(name);
    }
}
