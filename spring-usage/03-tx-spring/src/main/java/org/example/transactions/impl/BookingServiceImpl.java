package org.example.transactions.impl;

import org.example.transactions.api.BookingService;
import org.example.transactions.api.PersonService;
import org.example.transactions.exception.MyCustomException;
import org.example.transactions.model.Booking;
import org.example.transactions.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * User: chb
 */
@Service
public class BookingServiceImpl implements BookingService {

    @Autowired
    private PersonService personService;

    @Transactional
    public List<Booking> getAllBookingsForPerson(String personId) {
        Person person = personService.findById(personId);
        return null;
    }

    @Transactional(rollbackFor = MyCustomException.class)
    public void reserveRoomFor(String personId) {

    }

    @Transactional(noRollbackFor = IllegalAccessException.class)
    public void bookRoomFor(String personId) {

    }
}
