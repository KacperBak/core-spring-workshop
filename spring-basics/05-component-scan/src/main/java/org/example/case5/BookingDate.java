package org.example.case5;

import java.text.SimpleDateFormat;

/**
 * User: bakka
 * Date: 11.04.14
 */
public interface BookingDate {

    static final SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss - dd.MM.yyyy");

    String getFormattedDate();
}
