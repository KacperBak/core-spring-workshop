package org.example.domain.impl;

import org.example.domain.BookingDate;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.Date;

/**
 * User: bakka
 * Date: 13.04.14
 */
@Qualifier("dynamic")
public class UtilDateImpl implements BookingDate {

    private Date date = new Date();

    @Override
    public String getFormattedDate() {
        return sdf.format(date) + " provided by UtilDateImpl";
    }
}
