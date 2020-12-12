/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.boburmurtozaev.vendingmachine;

import com.boburmurtozaev.vendingmachine.controller.Controller;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author boburmurtozaev
 */
public class App {
    
    public static void main(String[] args) {
        
//        UserIO myIO = new UserIOImpl();
//        View myView = new View(myIO);
//        DataAccess myDA = new DataAccessFileImpl();
//        DataAccessAudit myAudit = new DataAccessAuditFileImpl();
//        VendingService vs = new VendingServiceImpl(myDA, myAudit);
//        Controller ctrl = new Controller(vs, myView);
//        ctrl.run();

        ApplicationContext ctx = 
           new ClassPathXmlApplicationContext("applicationContext1.xml");
        Controller controller = 
           ctx.getBean("controller", Controller.class);
        controller.run();

//        AnnotationConfigApplicationContext appContext2 = new AnnotationConfigApplicationContext();
//        appContext2.scan("com.boburmurtozaev.vendingmachine");
//        appContext2.refresh();
//
//        Controller contrl = appContext2.getBean("controller", Controller.class);
//        contrl.run();


    }
    
}
