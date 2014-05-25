package org.example.transactions.impl;

import org.example.transactions.api.PersonService;
import org.example.transactions.model.Person;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * User: chb
 */
@Service
public class PersonServiceImpl implements PersonService{

    @Transactional(propagation = Propagation.REQUIRED)
    public Person findById(String personId) {
        return null;
    }
}
