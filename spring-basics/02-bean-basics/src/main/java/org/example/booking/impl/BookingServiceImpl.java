package org.example.booking.impl;

import org.example.booking.Booking;
import org.example.booking.BookingService;
import org.example.date.impl.JodaTimeImpl;
import org.example.person.Person;
import org.example.person.PersonRepository;
import org.example.room.Room;
import org.example.room.RoomRepository;
import org.apache.commons.lang3.Validate;

/**
 * User: bakka
 */
public class BookingServiceImpl implements BookingService {

    private PersonRepository personRepository;

    private RoomRepository roomRepository;

    public BookingServiceImpl(PersonRepository personRepository, RoomRepository roomRepository) {
        this.personRepository = personRepository;
        this.roomRepository = roomRepository;
    }

    @Override
    public Booking book(String personName, String roomNumber) {
        Person person = personRepository.findPersonByName(personName);
        Room room = roomRepository.findRoomByNumber(roomNumber);
        Validate.notNull(person);
        Validate.notNull(room);
        Booking booking = new Booking(person, room, new JodaTimeImpl());
        return booking;
    }
}
