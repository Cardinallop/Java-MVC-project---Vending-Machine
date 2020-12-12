/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.boburmurtozaev.vendingmachine.dataaccess;

import com.boburmurtozaev.vendingmachine.dataobject.Item;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;


/**
 *
 * @author boburmurtozaev
 */

public class DataAccessFileImpl implements DataAccess {
    
    private Map<String, Item> vendingMachine = new HashMap<>();
    public final String STOCK;
    public static final String DELIMITER = "::";
    
  
    public DataAccessFileImpl(){
        
        STOCK = "inventory.txt";
    }
    
 
    public DataAccessFileImpl(String stockTextFile){
        
        STOCK = stockTextFile;
    }
   

    @Override
    public List<Item> getAllItems() throws DataPersistenceException {
        loadStock();
        return new ArrayList<Item>(vendingMachine.values());
    }

    @Override
    public Item getItem(String name) throws DataPersistenceException{
        
        loadStock();
        Item purchasedItem = vendingMachine.get(name);
        
        return purchasedItem;
        
//        int count = Integer.parseInt(purchasedItem.getCount());
//       
//        double itemPrice = Double.parseDouble(purchasedItem.getCost());
//        double changge = Double.parseDouble(penny.getAmount());
//        
//        if(count>0){
//            if(itemPrice<=changge){
//                vendingMachine.get(name).setCount(Integer.toString(--count));
//                 penny.setAmount(Double.toString(changge-itemPrice));
//            }
//        }
//        
//        writeStock();
//        return purchasedItem;
//        }catch(DataPersistenceException e){
//            throw new DataPersistenceException("Not enough bucks");
//        }
    }

    @Override
    public Item stockItem(String name, Item item) throws DataPersistenceException {
        
        loadStock();
        
        Item newItem = vendingMachine.put(name, item);
        writeStock();
        return newItem;
        
        
        
        
    }
    
    private Item unmarshallItem(String itemAsText){
        
        String[] itemTokens = itemAsText.split(DELIMITER);
        
        String itemName = itemTokens[0];
        
        Item itemFromFile = new Item(itemName);
        
        itemFromFile.setCost(itemTokens[1]);
        
        itemFromFile.setCount(itemTokens[2]);
        
        return itemFromFile;
        
    }
    
    private String marshallItem(Item item){
        String itemAsText = item.getName()+DELIMITER;
        
        itemAsText+=item.getCost() + DELIMITER;
        itemAsText+=item.getCount()+ DELIMITER;
        
        return itemAsText;
    }
    
     public void writeStock() throws DataPersistenceException {
        PrintWriter scanner;
        try {
            scanner = new PrintWriter(new FileWriter(STOCK));
        } catch (FileNotFoundException e) {
            throw new DataPersistenceException( "-_- Could not load roster data into memory.", e);
        } catch(Exception e){
            throw new DataPersistenceException("-_- Missing file", e);
        }
        String currentLine;
        for(Map.Entry<String, Item> thisItem: vendingMachine.entrySet()){
            scanner.println(marshallItem(thisItem.getValue()));
        }
        scanner.close();
    }
    
    
    private void loadStock() throws DataPersistenceException {
        Scanner scan;
        
        try{
            scan = new Scanner(
            new BufferedReader(
            new FileReader(STOCK)));
        }catch(FileNotFoundException e){
            throw new DataPersistenceException(
            "-_- Could no load inventory data into memory", e);
        }
        
        String currline;
        
        Item currItem;
        
        while(scan.hasNextLine()){
            currline = scan.nextLine();
            currItem = unmarshallItem(currline);
            
            vendingMachine.put(currItem.getName(), currItem);
        }
        
        scan.close();
    }

  

   
    
    
    
    
    
}
