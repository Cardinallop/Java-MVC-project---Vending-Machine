/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.boburmurtozaev.vendingmachine.dataaccess;

/**
 *
 * @author boburmurtozaev
 */
public class DataPersistenceException extends Exception {
    
    public DataPersistenceException(String message){
        super(message);
    }
    
    public DataPersistenceException(String message, Throwable cause){
        super(message, cause);
    }
    
}
