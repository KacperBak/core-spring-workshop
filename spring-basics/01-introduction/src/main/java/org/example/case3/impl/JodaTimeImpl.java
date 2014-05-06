package org.example.case3.impl;

import org.example.case3.BookingDate;
import org.joda.time.DateTime;

/**
 * User: bakka
 * Date: 13.04.14
 */
public class JodaTimeImpl implements BookingDate {

    private DateTime dateTime = new DateTime();

    @Override
    public String getFormattedDate() {
        return sdf.format(dateTime.toDate()) + " provided by JodaTimeImpl";
    }
}
