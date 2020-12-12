/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.boburmurtozaev.vendingmachine.dataaccessTest;

import com.boburmurtozaev.vendingmachine.dataaccess.DataAccessAudit;
import com.boburmurtozaev.vendingmachine.dataaccess.DataAccessAudit;
import com.boburmurtozaev.vendingmachine.dataaccess.DataPersistenceException;
import com.boburmurtozaev.vendingmachine.dataaccess.DataPersistenceException;
import org.springframework.stereotype.Component;

/**
 *
 * @author boburmurtozaev
 */


public class DataAccessAuditStubImpl implements DataAccessAudit {

    @Override
    public void writeAuditEntry(String entry) throws DataPersistenceException {
        
        //do nothing
        
    }
    
    
    
}
