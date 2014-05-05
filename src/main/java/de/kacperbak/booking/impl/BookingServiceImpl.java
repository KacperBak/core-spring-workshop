package de.kacperbak.booking.impl;

import de.kacperbak.booking.Booking;
import de.kacperbak.booking.BookingService;
import de.kacperbak.date.impl.JodaTimeImpl;
import de.kacperbak.person.Person;
import de.kacperbak.person.PersonRepository;
import de.kacperbak.room.Room;
import de.kacperbak.room.RoomRepository;
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
