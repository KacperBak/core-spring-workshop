package org.example.date.impl;

import org.example.date.BookingDate;

import java.util.Date;

/**
 * User: bakka
 * Date: 13.04.14
 */
public class UtilDateImpl implements BookingDate {

    private Date date = new Date();

    @Override
    public String getFormattedDate() {
        return sdf.format(date) + " provided by UtilDateImpl";
    }
}
