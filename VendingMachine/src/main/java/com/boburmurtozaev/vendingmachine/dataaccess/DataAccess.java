/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.boburmurtozaev.vendingmachine.dataaccess;

import com.boburmurtozaev.vendingmachine.dataobject.Change;
import com.boburmurtozaev.vendingmachine.dataobject.Item;
import java.util.List;

/**
 *
 * @author boburmurtozaev
 */
public interface DataAccess {
    
    Item stockItem(String name, Item item) throws DataPersistenceException;
    
    List<Item> getAllItems() throws DataPersistenceException;
    
    Item getItem(String name) throws DataPersistenceException;

//    void setChange(String change) throws DataPersistenceException;
//    
//    Change getChange() throws DataPersistenceException;
    
    void writeStock() throws DataPersistenceException;
    
}
