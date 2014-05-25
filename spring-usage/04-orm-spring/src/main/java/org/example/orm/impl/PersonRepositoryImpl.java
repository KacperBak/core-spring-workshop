package org.example.orm.impl;

import org.example.orm.api.PersonRepository;
import org.example.orm.model.Person;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import java.util.List;

/**
 * User: chb
 */
@Repository
public class PersonRepositoryImpl implements PersonRepository {

    @PersistenceContext(type = PersistenceContextType.EXTENDED)
    private EntityManager entityManager;

    @Override
    public Person findById(Long id) {
        return entityManager.find(Person.class, id);
    }

    @Override
    public List<Person> findAllByFirstName(String firstName) {
        Query query = entityManager.createQuery("select p from Person p where p.firstName = :firstName");
        query.setParameter("firstName", firstName);
        List<Person> persons = query.getResultList();
        return persons;
    }

    @Override
    public List<Person> findAllByLastName(String lastName) {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Person> query = builder.createQuery(Person.class);
        Predicate condition = builder.equal(query.from(Person.class).get("lastName"), lastName);
        query.where(condition);
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public List<Person> findAllPersonsOlderThan(int age) {
        Query query = entityManager.createNativeQuery("SELECT * FROM PERSON p WHERE p.AGE > ?");
        query.setParameter(1, age);
        List<Person> persons = query.getResultList();
        return persons;
    }

    @Override
    @Transactional
    public void addPerson(Person person) {
        entityManager.persist(person);
    }

}
