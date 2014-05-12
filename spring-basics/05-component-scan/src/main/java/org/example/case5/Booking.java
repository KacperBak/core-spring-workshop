package org.example.case5;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * User: bakka
 * Date: 31.03.14
 */
@Component
public class Booking {

    private Person person;

    private Room room;

    private BookingDate bookingDate;

    @Autowired
    public Booking(Person person, Room room, BookingDate bookingDate) {
        this.person = person;
        this.room = room;
        this.bookingDate = bookingDate;
    }

    // NOTE: No setters defined!

    public Person getPerson() {
        return person;
    }

    public Room getRoom() {
        return room;
    }

    public BookingDate getBookingDate() {
        return bookingDate;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "person=" + person +
                ", room=" + room +
                ", bookingDate='" + bookingDate.getFormattedDate() + '\'' +
                '}';
    }
}
