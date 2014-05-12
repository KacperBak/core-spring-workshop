package org.example.case6.impl;

import org.example.case6.BookingDate;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * User: bakka
 * Date: 13.04.14
 */
@Component
public class UtilDateImpl implements BookingDate {

    private Date date = new Date();

    @Override
    public String getFormattedDate() {
        return sdf.format(date) + " provided by UtilDateImpl";
    }
}
