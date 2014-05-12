package org.example.case1;

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

    @Autowired
    public Booking(Person person, Room room) {
        this.person = person;
        this.room = room;
    }

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
