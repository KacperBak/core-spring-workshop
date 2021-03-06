package org.example.domain;

/**
 * User: bakka
 * Date: 31.03.14
 */
public class Booking {

    private Person person;

    private Room room;

    public Booking() {
    }

    public Booking(Room room) {
        this.room = room;
    }

    public Booking(Person person, Room room) {
        this.person = person;
        this.room = room;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "person=" + person +
                ", room=" + room +
                '}';
    }
}
