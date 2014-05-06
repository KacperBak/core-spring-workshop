package org.example.case4.impl;

import org.example.case4.BookingDate;
import org.example.case4.BookingService;

/**
 * User: bakka
 * Date: 27.04.14
 */
public class BookingServiceImpl implements BookingService {

    private BookingDate bookingDate;

    public BookingServiceImpl(BookingDate bookingDate) {
        this.bookingDate = bookingDate;
    }

    @Override
    public String displayBooking() {
        String result = "Booking SUCCEED on " + bookingDate.getFormattedDate();
        System.out.println(result);
        return result;
    }
}
