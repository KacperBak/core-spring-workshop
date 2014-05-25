package org.example.person.impl;

import org.example.person.Person;
import org.example.person.PersonRepository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * User: bakka
 */
public class JdbcPersonRepositoryImpl implements PersonRepository {

    /**
     * Creates and handles db connection, no more DriverManager needed.
     */
    private DataSource dataSource;

    public JdbcPersonRepositoryImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public Person findPersonByName(String name) {

        Person person = null;
        Connection connection = null;
        PreparedStatement statement = null;
        try{
            String personName = null;
            Integer personAge = null;
            String sql = "SELECT p.NAME AS PERSON_NAME, p.AGE as PERSON_AGE FROM Person p WHERE p.NAME = ?";
            connection = dataSource.getConnection();
            statement = connection.prepareStatement(sql);
            statement.setString(1, name);

            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                personName = resultSet.getString("PERSON_NAME");
                personAge = resultSet.getInt("PERSON_AGE");
            }
            person = createPerson(personName, personAge);

        } catch (SQLException ex){
            System.out.println(ex);
        } finally {
            tearDown(statement, connection);
        }

        return person;
    }

    private Person createPerson(String name, Integer age){
        return ((name != null) && (age != null )) ? new Person(name, age) : null;
    }

    private void tearDown(PreparedStatement statement, Connection connection){
        try{
            if(statement != null){
                statement.close();
            }
        } catch (SQLException ex){
            System.out.println(ex);
        }
        try{
            if(connection != null){
                connection.close();
            }
        } catch (SQLException ex){
            System.out.println(ex);
        }
    }
}
