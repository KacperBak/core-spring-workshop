package org.example.transactions.impl;

import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;
import org.testng.annotations.Test;

/**
 * User: chb
 */
@ContextConfiguration(locations = {"classpath:org/example/transactions/spring-config.xml"})
@TransactionConfiguration(defaultRollback = false, transactionManager = "txMgr")
@Transactional
public class BookingServiceImplTest extends AbstractTestNGSpringContextTests{

//    @Test
//    @Rollback(true)
//    public void testGetAllBookingsForPerson() {
//        //test
//    }
}
