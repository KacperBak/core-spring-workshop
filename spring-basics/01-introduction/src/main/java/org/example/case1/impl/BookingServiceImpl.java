package org.example.case1.impl;

import org.example.case1.BookingService;

/**
 * User: bakka
 * Date: 27.04.14
 */
public class BookingServiceImpl implements BookingService {

    @Override
    public String displayBooking() {
        String result = "Booking SUCCEED on " + new UtilDateImpl().getFormattedDate();
        System.out.println(result);
        return result;
    }
}
