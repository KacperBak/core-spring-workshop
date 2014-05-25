package org.example.orm.model;

import javax.persistence.*;
import java.util.Set;

/**
 *
 */
@Entity
@Table(name = "PERSON")
public class Person {

    @Id
    @SequenceGenerator( name = "personSeq", sequenceName = "PERSON_SEQ", allocationSize = 1, initialValue = 1 )
    @GeneratedValue( strategy = GenerationType.SEQUENCE, generator = "personSeq" )
    @Column(name = "ID")
    private Long id;

    @Column(name = "FIRST_NAME")
    private String firstName;

    @Column(name = "LAST_NAME")
    private String lastName;

    @Column(name = "AGE")
    private int age;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "PERSON_ID")
    private Set<Booking> bookings;

    public Person(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public String getFirstName() {
        return firstName;
    }

    public int getAge() {
        return age;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", bookings=" + bookings +
                '}';
    }
}
