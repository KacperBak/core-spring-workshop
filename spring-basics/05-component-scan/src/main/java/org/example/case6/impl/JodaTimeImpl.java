package org.example.case6.impl;

import org.example.case6.BookingDate;
import org.example.case6.Impl;
import org.joda.time.DateTime;

/**
 * User: bakka
 * Date: 13.04.14
 */
@Impl
public class JodaTimeImpl implements BookingDate {

    private DateTime dateTime = new DateTime();

    @Override
    public String getFormattedDate() {
        return sdf.format(dateTime.toDate()) + "provided by JodaTimeImpl";
    }
}
