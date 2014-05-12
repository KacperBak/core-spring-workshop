package org.example.domain.impl;

import org.example.domain.BookingDate;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Qualifier;

/**
 * User: bakka
 * Date: 13.04.14
 */
@Qualifier("dynamic")
public class JodaTimeImpl implements BookingDate {

    private DateTime dateTime = new DateTime();

    @Override
    public String getFormattedDate() {
        return sdf.format(dateTime.toDate()) + "provided by JodaTimeImpl";
    }
}
