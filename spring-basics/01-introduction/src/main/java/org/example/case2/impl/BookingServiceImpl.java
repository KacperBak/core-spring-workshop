package org.example.case2.impl;

import org.example.case2.BookingDate;
import org.example.case2.BookingService;

/**
 * User: bakka
 * Date: 27.04.14
 */
public abstract class BookingServiceImpl implements BookingService {

    @Override
    public String displayBooking() {
        String result = "Booking SUCCEED on " + getBookingDate().getFormattedDate();
        System.out.println(result);
        return result;
    }

    /**
     * Hook for concrete implementation
     * @return
     */
    protected abstract BookingDate getBookingDate();

}
