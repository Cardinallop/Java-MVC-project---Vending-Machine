/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.boburmurtozaev.vendingmachine.dataaccess;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import org.springframework.stereotype.Component;

/**
 *
 * @author boburmurtozaev
 */

public class DataAccessAuditFileImpl implements DataAccessAudit{
    
    public static final String AUDITT = "VMaudit.txt";


    public void writeAuditEntry(String entry) throws DataPersistenceException {
      
        PrintWriter out;
        
        try{
            out = new PrintWriter(new FileWriter(AUDITT, true));
            
        }catch(IOException e){
            throw new DataPersistenceException("Could not persist audit info", e);
        }
        
        LocalDateTime timestamp = LocalDateTime.now();
        
        out.println(timestamp.toString()+" : "+entry);
        out.flush();
        
    }
    
}
