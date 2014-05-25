package org.example.transactions.api;

import org.example.transactions.model.Booking;

import java.util.List;

/**
 * User: chb
 */
public interface BookingService {

    public List<Booking> getAllBookingsForPerson(String personId);

    public void reserveRoomFor(String personId);

    public void bookRoomFor(String personId);
}
