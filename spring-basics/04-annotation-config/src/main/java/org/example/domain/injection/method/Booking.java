package org.example.domain.injection.method;

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

    /**
     * Setter does NOT follow bean name convention, but is injected correctly
     * @param person
     */
    @Autowired
    public void setFoo(Person person) {
        this.person = person;
    }

    /**
     * This bean is REAL optional => (required = false)
     * @param room
     */
    @Autowired(required = false)
    public void setRoom(Room room) {
        this.room = room;
    }


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
