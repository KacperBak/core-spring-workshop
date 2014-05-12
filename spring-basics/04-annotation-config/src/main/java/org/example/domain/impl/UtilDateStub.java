package org.example.domain.impl;

import org.example.domain.BookingDate;
import org.example.domain.Stub;
import org.springframework.beans.factory.annotation.Qualifier;

/**
 * User: bakka
 * Date: 13.04.14
 */
@Qualifier("static")
@Stub
public class UtilDateStub implements BookingDate{

    @Override
    public String getFormattedDate() {
        return "00:00:00 - 00.00.0000 provided by UtilDateStub";
    }
}
