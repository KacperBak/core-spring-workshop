package org.example.domain.injection.ctor;

import org.example.domain.Person;
import org.example.domain.Room;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * User: bakka
 * Date: 31.03.14
 */
public class Booking {

    private Person person;

    private Room room;

    public Booking() {
    }

    /**
     * Possible null values, if this ctor is annotated with @Autowired
     * @param person
     */
    public Booking(Person person) {
        this.person = person;
    }

    /**
     * Greedy algorithm, annotate the most greedy ctor with @Autowired
     * @param person
     * @param room
     */
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
