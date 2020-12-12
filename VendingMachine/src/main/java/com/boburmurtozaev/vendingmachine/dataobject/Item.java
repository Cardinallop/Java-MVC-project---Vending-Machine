/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.boburmurtozaev.vendingmachine.dataobject;

import java.math.BigDecimal;
import java.util.Objects;

/**
 *
 * @author boburmurtozaev
 */

public class Item {
    
    private String name;
    private BigDecimal cost;
    private String count;
    
    public Item(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    
    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = new BigDecimal(cost);
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + Objects.hashCode(this.name);
        hash = 23 * hash + Objects.hashCode(this.cost);
        hash = 23 * hash + Objects.hashCode(this.count);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Item other = (Item) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.cost, other.cost)) {
            return false;
        }
        if (!Objects.equals(this.count, other.count)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Item{" + "name=" + name + ", cost=" + cost + ", count=" + count + '}';
    }
    
    
}
