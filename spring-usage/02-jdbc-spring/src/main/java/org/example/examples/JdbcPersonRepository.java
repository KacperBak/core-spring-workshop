package org.example.examples;

import org.example.model.Booking;
import org.example.model.Person;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

/**
 * User: chb
 */
public class JdbcPersonRepository {

    private JdbcTemplate jdbcTemplate;

    public JdbcPersonRepository(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public int getPersonCount() {
        String sql = "SELECT COUNT(*) FROM PERSON";
        return jdbcTemplate.queryForObject(sql, Integer.class);
    }

    public int getCountOfPersonsOlderThan(int age) {
        String sql = "SELECT COUNT(*) FROM PERSON WHERE AGE > ?";
        return jdbcTemplate.queryForObject(sql, Integer.class, age);
    }

    public Person getPerson(int id){
        return jdbcTemplate.queryForObject("SELECT NAME, AGE, FROM PERSON WHERE id=?", new PersonMapper(), id);
    }

    public void generatePersonReport(){
        jdbcTemplate.query("SELECT * FROM PERSON", new PersonWriter());
    }

    public Booking findBookingByNumber(String bookingNumber){
        return jdbcTemplate.query("SELECT * FROM BOOKING b, PERSON, ROOM b.id = ?", new BookingExtractor(), bookingNumber);
    }

}
