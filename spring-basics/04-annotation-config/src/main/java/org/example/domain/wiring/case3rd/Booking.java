package org.example.domain.wiring.case3rd;

import org.example.domain.BookingDate;
import org.example.domain.Person;
import org.example.domain.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

/**
 * User: bakka
 * Date: 31.03.14
 */
public class Booking {

    private Person person;

    private Room room;

    private BookingDate bookingDate;

    @Autowired
    public Booking(Person person, Room room, @Qualifier("dynamic") BookingDate bookingDate) {
        this.person = person;
        this.room = room;
        this.bookingDate = bookingDate;
    }

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
