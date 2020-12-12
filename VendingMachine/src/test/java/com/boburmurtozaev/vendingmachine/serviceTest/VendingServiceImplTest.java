/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.boburmurtozaev.vendingmachine.serviceTest;

import com.boburmurtozaev.vendingmachine.dataaccess.DataPersistenceException;
import com.boburmurtozaev.vendingmachine.dataobject.Change;
import com.boburmurtozaev.vendingmachine.dataobject.Item;
import com.boburmurtozaev.vendingmachine.service.InsufficientFundsException;
import com.boburmurtozaev.vendingmachine.service.NoItemInventoryException;
import com.boburmurtozaev.vendingmachine.service.VendingServiceImpl;
import static org.junit.jupiter.api.Assertions.fail;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author boburmurtozaev
 */
public class VendingServiceImplTest {

    private VendingServiceImpl service;

    public VendingServiceImplTest() {

//        DataAccess das = new DataAccessStubImpl();
//        DataAccessAudit dau = new DataAccessAuditStubImpl();
//       
//        serv = new VendingServiceImpl(das, dau);
//
//        AnnotationConfigApplicationContext appContext1 = new AnnotationConfigApplicationContext();
//        appContext1.scan("com.boburmurtozaev.vendingmachine.service");
//        
//        appContext1.refresh();
//        
//        vsit = appContext1.getBean("vendingServiceImpl", VendingServiceImpl.class);
//       
//        //System.out.println(vsit);



        ApplicationContext ctx
                = new ClassPathXmlApplicationContext("applicationContext2.xml");

       
         service = ctx.getBean("service", VendingServiceImpl.class);

    }

    @BeforeEach
    public void setUp() {

    }

    @Test
    public void testGetItem() throws Exception {

        
        try {
            Item itm = new Item("Gum");
            itm.setCost("2.25");
            itm.setCount("13");

            service.setChange("2000");
           

            service.stockItem(itm.getName(), itm);
            service.getItem(itm.getName());
        } catch (DataPersistenceException
                | InsufficientFundsException | NoItemInventoryException e) {

            fail("Item was valid. No exception should have been thrown");

        }
        
        
        
        

//        Item shouldbeSolar = vsit.getItem("Solar");
//        
//        
//        assertNotNull(shouldbeSolar, "Getting Solar should not be null");
//        assertEquals(itm, shouldbeSolar, "Item stored under Solar should be Solar");
//        
//        Item shouldbeNull = vsit.getItem("Gear");
//        assertNull(shouldbeNull, "Getting Gear should be null");
//        //fail("The test case is a prototype.");
    }

}
