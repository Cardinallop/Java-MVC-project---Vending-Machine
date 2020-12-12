/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.boburmurtozaev.vendingmachine.dataaccessTest;

import com.boburmurtozaev.vendingmachine.dataaccess.DataAccess;
import com.boburmurtozaev.vendingmachine.dataaccess.DataAccess;
import com.boburmurtozaev.vendingmachine.dataaccess.DataPersistenceException;
import com.boburmurtozaev.vendingmachine.dataaccess.DataPersistenceException;
import com.boburmurtozaev.vendingmachine.dataobject.Item;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author boburmurtozaev
 */


public class DataAccessStubImpl implements DataAccess {
     //@Autowired
    public Item onlyItem;
    
    

    public DataAccessStubImpl(){
        
        onlyItem = new Item("Solar");
        onlyItem.setCost("9.76");
        onlyItem.setCount("29");
    }
    
   
    public DataAccessStubImpl(Item testItem){
        this.onlyItem = testItem;
    }

    @Override
    public Item stockItem(String name, Item item) throws DataPersistenceException {
        if(!name.equals(onlyItem.getName())){
            return onlyItem;
        }else{
            return null;
        }
    }

    @Override
    public List<Item> getAllItems() throws DataPersistenceException {
       
        List<Item> itemlist = new ArrayList<>();
        
        itemlist.add(onlyItem);
        
        return itemlist;
    }

    @Override
    public Item getItem(String name) throws DataPersistenceException {
        
        if(name.equals(onlyItem.getName())){
            return onlyItem;
        }else{
            return null;
        }
    }

    @Override
    public void writeStock() throws DataPersistenceException {
        //do nothing;
    }

    

    
    
}
