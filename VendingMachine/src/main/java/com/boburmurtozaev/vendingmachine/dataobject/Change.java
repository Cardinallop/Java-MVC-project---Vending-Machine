/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.boburmurtozaev.vendingmachine.dataobject;

import java.math.BigDecimal;

/**
 *
 * @author boburmurtozaev
 */
public class Change {

    private BigDecimal amount = new BigDecimal(444);

    public Change(String change) {

        this.amount = new BigDecimal(change);
    }

    public void setAmount(double amount) {
        this.amount = new BigDecimal(amount);

    }

    public BigDecimal getAmount() {
        return amount;
    }

    public enum Coins {
        PENNIES, NICKELS, DIMES, QUARTERS
    }

}
