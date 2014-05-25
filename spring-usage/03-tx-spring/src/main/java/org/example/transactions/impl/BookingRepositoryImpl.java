package org.example.transactions.impl;

import org.example.transactions.api.BookingRepository;
import org.example.transactions.model.Person;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

/**
 * User: chb
 */
@Transactional(timeout = 60)
@Repository
public class BookingRepositoryImpl implements BookingRepository {


    @Transactional(isolation = Isolation.READ_UNCOMMITTED)
    public void reserveRoomFor(Person person) {
        //atomic
    }

    @Transactional(timeout = 30)
    public void bookRoomFor(Person person) {
        //atomic too, but different timeout
    }

}
