package org.example.transactions.api;

import org.example.transactions.model.Person;

/**
 * User: chb
 */
public interface PersonService {

    public Person findById(String personId);
}
