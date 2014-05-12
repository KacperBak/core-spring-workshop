package org.example.case2.impl;

import org.example.case2.BookingDate;
import org.joda.time.DateTime;
import org.springframework.stereotype.Component;

/**
 * User: bakka
 * Date: 13.04.14
 */
@Component
public class JodaTimeImpl implements BookingDate {

    private DateTime dateTime = new DateTime();

    @Override
    public String getFormattedDate() {
        return sdf.format(dateTime.toDate()) + "provided by JodaTimeImpl";
    }
}
