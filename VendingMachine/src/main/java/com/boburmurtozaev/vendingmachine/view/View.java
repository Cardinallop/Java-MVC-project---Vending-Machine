/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.boburmurtozaev.vendingmachine.view;

import com.boburmurtozaev.vendingmachine.dataobject.Item;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author boburmurtozaev
 */

public class View {
    
    private UserIO io;
    

    public View(UserIO io){
        this.io = io;
    }
    
    public int printMenuAndSelection(){
        io.print("Main menu");
        io.print("1. Display items and prices");
        io.print("2. Enter amount in pennies");
        io.print("3. Purchase an item");
        io.print("4. Exit");
        
        return io.readInt("Please select from "
                    + "above choices.", 1, 5 );
    }
    
    public void displayItemList(List<Item> itemList){
        for(Item currentItem : itemList){
            String itemInfo = String.format("%s : $%s each, %s counts available\n", 
                    currentItem.getName(),
                    currentItem.getCost(),
                    currentItem.getCount());
            io.print(itemInfo);
        }
        
        io.readString("Please hit enter to continue");
    }
    
    public String getItemChoice(){
        return io.readString("Please enter item name");
    }
    
    public void displayItem(Item item){
        if(item!=null){
            io.print("You bought one "+item.getName());
            io.print("$"+item.getCost()+ " each, " + item.getCount()+" counts available");
            io.print(" ");
        } else {
            io.print("No such Item.");
        }
        
        io.readString("Please hit enter to continue");
    }
    
    public void displayDisplayAllBanner(){
        io.print("=== Display All Items ===");
    }
    
    public void displayItemBanner(){
        io.print("=== Purchasing Item ===");
    }
    
    public void displayPurchaseResult(Item item){
        if(item!=null){
            io.print("Item successfully been purchased");
        } else {
            io.print("No such item");
        }
        
        io.readString("Please hit enter to continue");
    }
    
    public void displayExitBanner(){
        io.print("Good Bye!!");
    }
    
    public void displayUnknownCommandBanner(){
        io.print("Unknown Command");
    }
    
    public void displayEnterCreditBanner(){
        io.print("=== Enter Credit ===");
    }
    
    public void displayErrorMessage(String errorMsg){
        io.print("=== ERROR ===");
        io.print(errorMsg);
    }

    public String getChange() {
        return io.readString("Enter your change amount in pennies");
    }

    public void displayChangeAmount(String change) {
        
        double penny = Double.parseDouble(change);
        int dollar = (int)penny/100;
        int cents = (int)(dollar/100+(penny%100));
        
        String dol = String.valueOf(dollar);
        String cc = String.valueOf(cents);

        io.print("=== You have "+dol+","+cc+" dollars available for purchases ===");
        
        //io.print("=== You have "+change+" dollars available for purchases ===");
    }
    
}
