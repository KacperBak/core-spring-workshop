package org.example.transactions.api;

import org.example.transactions.model.Person;

/**
 * User: chb
 */
public interface BookingRepository {

    public void reserveRoomFor(Person person);

    public void bookRoomFor(Person person);

}
