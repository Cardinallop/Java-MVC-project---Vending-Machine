/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.boburmurtozaev.vendingmachine.dataaccessTest;

import com.boburmurtozaev.vendingmachine.dataaccess.DataAccess;
import com.boburmurtozaev.vendingmachine.dataaccess.DataAccess;
import com.boburmurtozaev.vendingmachine.dataaccess.DataAccessFileImpl;
import com.boburmurtozaev.vendingmachine.dataaccess.DataAccessFileImpl;
import com.boburmurtozaev.vendingmachine.dataobject.Item;
import java.io.FileWriter;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 *
 * @author boburmurtozaev
 */
public class DataAccessFileImplTest {
    
    DataAccess testda;
    
    
    public DataAccessFileImplTest() {
    }
    
   
    
    @BeforeEach
    public void setUp() throws Exception {
        
        String testFile = "testInventory.txt";
        
        //new FileWriter(testFile);
        
        testda = new DataAccessFileImpl(testFile);
    }
    
    //public List<Item> getAllItems() throws DataPersistenceException
    //public Item getItem(String name) throws DataPersistenceException
  
    
    @Test
    public void testGetAllItems() throws Exception {
        
        List<Item> allItems = testda.getAllItems();
        
        Item it44 = testda.getItem("Solar");
        Item it45 = testda.getItem("Polar");
        
        assertNotNull(allItems, "The list must not be null");
        assertEquals(5, allItems.size(), "List should have 5 items");
        
        assertTrue(testda.getAllItems().contains(it44), "the List should have an item called Polar");
        
        assertTrue(testda.getAllItems().contains(it45), "the list should contain item called Solar");
        
        
    }
    
    @Test
    public void testGetItem() throws Exception{
        
        Item item8 = testda.getItem("Rolar");
        String cost = "4.25";
        String count = "16";
        
        assertEquals(item8.getCost().toString(), cost, "Cost should be equal");
        assertEquals(item8.getCount(), count, "both counts should be similar");
        
    }
}
