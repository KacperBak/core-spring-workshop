package org.example.examples;

import org.example.model.Booking;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * User: chb
 */
public class BookingExtractor implements ResultSetExtractor<Booking> {
    @Override
    public Booking extractData(ResultSet rs) throws SQLException, DataAccessException {
        //create an Booking object with items from multiple rows
        return null;
    }
}
