package org.example.booking;

import org.example.date.BookingDate;
import org.example.date.impl.UtilDateImpl;
import org.example.person.Person;
import org.example.room.Room;

/**
 * User: bakka
 */
public class Booking {

    private Person person;

    private Room room;

    private BookingDate bookingDate;

    public Booking(Person person, Room room, BookingDate bookingDate) {
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

    public void setBookingDate(BookingDate bookingDate) {
        this.bookingDate = bookingDate;
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
