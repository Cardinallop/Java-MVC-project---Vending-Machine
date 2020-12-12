/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.boburmurtozaev.vendingmachine.controller;

import com.boburmurtozaev.vendingmachine.dataaccess.DataPersistenceException;
import com.boburmurtozaev.vendingmachine.dataobject.Change;
import com.boburmurtozaev.vendingmachine.dataobject.Item;
import com.boburmurtozaev.vendingmachine.service.VendingService;
import com.boburmurtozaev.vendingmachine.view.View;
import java.util.List;



/**
 *
 * @author boburmurtozaev
 */

public class Controller {

    private View view;
    private VendingService vs;


    public Controller(VendingService vs, View view) {
        this.view = view;
        this.vs = vs;

    }

    public void run() {
        boolean keepGoing = true;
        int menuSelection = 0;

        try {
            while (keepGoing) {
                menuSelection = getMenuSelection();

                switch (menuSelection) {
                    case 1:
                        displayItems();
                        break;
                    case 2:
                        enterChange();
                        break;
                    case 3:
                        purchaseItem();
                        break;
                    case 4:
                        keepGoing = false;
                        break;
                    default:
                        unknownCommand();
                }

            }

            exitMessage();
        } catch (DataPersistenceException e) {
            view.displayErrorMessage(e.getMessage());
        }

    }

    private int getMenuSelection() {

        return view.printMenuAndSelection();

    }

    private void displayItems() throws DataPersistenceException {
        view.displayDisplayAllBanner();
        List<Item> itemList = vs.getAllItems();
        view.displayItemList(itemList);
    }

    private void enterChange() throws DataPersistenceException {
        view.displayEnterCreditBanner();
        String change = view.getChange();
        vs.setChange(change);
        view.displayChangeAmount(change);
    }

    private void purchaseItem() throws DataPersistenceException {
        view.displayItemBanner();
        try {
            String itemName = view.getItemChoice();
            Item item = vs.getItem(itemName);
            view.displayItem(item);
            view.displayChangeAmount(vs.getChange());
        } catch (Exception e) {
            throw new DataPersistenceException(""
                    + "You may have forgotten entering some change for purchasing");
        }
    }

    public void unknownCommand() {
        view.displayUnknownCommandBanner();
    }

    private void exitMessage() {
        view.displayExitBanner();
    }

}
