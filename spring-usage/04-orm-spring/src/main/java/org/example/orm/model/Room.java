package org.example.orm.model;

import javax.persistence.*;

/**
 * User: bakka
 */
@Entity
@Table(name = "ROOM")
public class Room {

    @Id
    @SequenceGenerator( name = "roomSeq", sequenceName = "ROOM_SEQ", allocationSize = 1, initialValue = 1 )
    @GeneratedValue( strategy = GenerationType.SEQUENCE, generator = "roomSeq" )
    @Column(name = "ID")
    private Long id;

    private String roomNumber;

    public Room(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    @Override
    public String toString() {
        return "Room{" +
                "roomNumber='" + roomNumber + '\'' +
                '}';
    }
}
