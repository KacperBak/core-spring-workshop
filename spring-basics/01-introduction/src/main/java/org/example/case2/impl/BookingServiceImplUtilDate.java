package org.example.case2.impl;

import org.example.case2.BookingDate;

/**
 * User: bakka
 * Date: 27.04.14
 */
public class BookingServiceImplUtilDate extends BookingServiceImpl{

    @Override
    protected BookingDate getBookingDate() {
        return new UtilDateImpl();
    }
}
