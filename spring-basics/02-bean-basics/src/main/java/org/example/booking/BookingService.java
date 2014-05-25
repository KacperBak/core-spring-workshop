package org.example.booking;

/**
 * Service for the booking application
 */
public interface BookingService {

    /**
     * Makes a lookup for existing entries
     * @param personName
     * @param roomNumber
     * @return if lookup successful a Booking object is returned
     */
    Booking book(String personName, String roomNumber);
}
