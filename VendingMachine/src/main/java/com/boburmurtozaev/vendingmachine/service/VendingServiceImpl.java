/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.boburmurtozaev.vendingmachine.service;

import com.boburmurtozaev.vendingmachine.dataaccess.DataAccess;
import com.boburmurtozaev.vendingmachine.dataaccess.DataAccessAudit;
import com.boburmurtozaev.vendingmachine.dataaccess.DataPersistenceException;
import com.boburmurtozaev.vendingmachine.dataobject.Change;
import com.boburmurtozaev.vendingmachine.dataobject.Item;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author boburmurtozaev
 */

public class VendingServiceImpl implements VendingService {

    private DataAccess da;
    private DataAccessAudit auditt;

    private Change penny;


    public VendingServiceImpl(DataAccess da, DataAccessAudit audit) {
        this.da = da;
        this.auditt = audit;
    }


    public void stockItem(String name, Item item) throws DataPersistenceException {
       da.stockItem(name, item);
        
    }

    @Override
    public List<Item> getAllItems() throws DataPersistenceException {
        return da.getAllItems();
    }

    @Override
    public Item getItem(String name) throws DataPersistenceException,
            InsufficientFundsException, NoItemInventoryException {

        Item purchasedItem = da.getItem(name);

        int count = Integer.parseInt(purchasedItem.getCount());

        BigDecimal itemPrice = purchasedItem.getCost();
        BigDecimal changge = penny.getAmount();

        if (count > 0) {
            if (itemPrice.doubleValue() <= changge.doubleValue()) {
                count--;
                purchasedItem.setCount((String.valueOf(count)));

                double diff = changge.doubleValue() - (itemPrice.doubleValue())*100;
                
                
                penny.setAmount(diff);
            } else {
                throw new InsufficientFundsException("Not enough funds");
            }
        } else {
            throw new NoItemInventoryException("Not available in stock");
        }

        da.stockItem(purchasedItem.getName(), purchasedItem);

        auditt.writeAuditEntry("Item " + purchasedItem.getName() + " was purchased.");

        da.writeStock();
        return purchasedItem;

    }

    @Override
    public void setChange(String change) throws DataPersistenceException {

        penny = new Change(change);

        penny.setAmount(Double.parseDouble(change));

    }

    @Override
    public String getChange() throws DataPersistenceException {

        return penny.getAmount().toString();

    }

}
