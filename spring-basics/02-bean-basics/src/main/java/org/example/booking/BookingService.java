package org.example.booking;

/**
 * Service for the booking application
 */
public interface BookingService {

    /**
     * Makes a lookup for existing entries, and writes a SUCCESSFUL booking to stdout
     * @param personName
     * @param roomNumber
     */
    Booking book(String personName, String roomNumber);
}
