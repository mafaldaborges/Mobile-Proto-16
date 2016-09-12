package com.example;

/**
 * Created by mafaldaborges on 9/8/16.
 */
public class CheckingAccount extends Account {
    private long amount;
    
    public CheckingAccount (long amount) {

        super(amount);
        this.amount = amount;
    }

    public String toString() {
        return "Checking Account Balance: $" + amount;
    }

    public void withdraw(long moneyout){
        amount = amount - moneyout;
    }
    public void deposit(long moneyin){
        amount = amount + moneyin;
    }

}
