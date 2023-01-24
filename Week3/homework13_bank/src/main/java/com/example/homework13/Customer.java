package com.example.homework13;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Customer {
    private String id;
    private String username;
    private double balance;

    public boolean deposit(double money){
        balance+=money;
        return true;
    }
    public boolean withdraw(double money){
        if(balance>= money){
            balance-= money;
            return true;
        }
        return false;
    }


}
