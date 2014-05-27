package org.example.transactions.impl;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.transaction.BeforeTransaction;
import org.springframework.transaction.annotation.Transactional;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * User: chb
 */
@ContextConfiguration(locations = {"classpath:org/example/transactions/spring-config.xml"})
public class PersonServiceImplTest extends AbstractTestNGSpringContextTests{

//    @BeforeTransaction
//    public void initDb() {}

//    @BeforeMethod
//    public void setUpDataInTransaction(){
//        //before each test method
//    }
//
//    @Test
//    @Transactional
//    public void testGetPersonById() {
//        //do test
//    }
}
