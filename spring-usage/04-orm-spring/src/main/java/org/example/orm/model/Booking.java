package org.example.orm.model;

import javax.persistence.*;
import java.util.Date;

/**
 * User: bakka
 */
@Entity
@Table(name = "BOOKING")
public class Booking {

    @Id
    @SequenceGenerator( name = "bookingSeq", sequenceName = "BOOKING_SEQ", allocationSize = 1, initialValue = 1 )
    @GeneratedValue( strategy = GenerationType.SEQUENCE, generator = "bookingSeq" )
    @Column(name = "ID")
    private Long id;

    @JoinColumn(name = "PERSON_ID")
    @ManyToOne
    private Person person;

    @JoinColumn(name = "ROOM_ID")
    @ManyToOne
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
