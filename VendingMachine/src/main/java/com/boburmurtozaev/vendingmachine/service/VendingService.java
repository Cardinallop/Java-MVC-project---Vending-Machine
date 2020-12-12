/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.boburmurtozaev.vendingmachine.service;

import com.boburmurtozaev.vendingmachine.dataaccess.DataPersistenceException;
import com.boburmurtozaev.vendingmachine.dataobject.Item;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author boburmurtozaev
 */
public interface VendingService {
    
     void stockItem(String name, Item item) throws DataPersistenceException;
    
    List<Item> getAllItems() throws DataPersistenceException;
    
    Item getItem(String name) throws DataPersistenceException, 
            InsufficientFundsException, NoItemInventoryException;

    void setChange(String change) throws DataPersistenceException;
    
    String getChange() throws DataPersistenceException;
    
}
