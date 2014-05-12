package org.example.domain.injection.field;

import org.example.domain.Person;
import org.example.domain.Room;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * User: bakka
 * Date: 31.03.14
 */
public class Booking {

    @Autowired
    private Person person;

    @Autowired
    private Room room;

    // NOTE: No setters defined!

    public Person getPerson() {
        return person;
    }

    public Room getRoom() {
        return room;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "person=" + person +
                ", room=" + room +
                '}';
    }
}
