package org.example.domain.injection.field;

import org.example.domain.Person;
import org.example.domain.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

/**
 * User: bakka
 * Date: 31.03.14
 */
public class Booking {

    @Value("#{micha}")
    private Person person;

    @Autowired
    private Room room;

    @Value("${bookingDate}")
    private String bookinDate;

    // NOTE: No setters defined!

    public Person getPerson() {
        return person;
    }

    public Room getRoom() {
        return room;
    }

    public String getBookinDate() {
        return bookinDate;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "person=" + person +
                ", room=" + room +
                '}';
    }
}
