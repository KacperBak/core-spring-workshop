package org.example.transactions.model;

import java.util.Date;

/**
 * User: bakka
 */
public class Booking {

    private Person person;
    private Room room;
    private Date bookingDate;

    public Booking(Person person, Room room, Date bookingDate) {
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

    public Date getBookingDate() {
        return bookingDate;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "person=" + person +
                ", room=" + room +
                ", bookingDate=" + bookingDate +
                '}';
    }
}
