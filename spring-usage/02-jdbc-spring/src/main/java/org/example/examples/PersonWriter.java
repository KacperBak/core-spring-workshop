package org.example.examples;

import org.springframework.jdbc.core.RowCallbackHandler;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * User: chb
 */
public class PersonWriter implements RowCallbackHandler {

    @Override
    public void processRow(ResultSet rs) throws SQLException {
        //do it!
    }
}
