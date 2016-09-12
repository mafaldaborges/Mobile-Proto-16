package com.example;

/**
 * Created by mafaldaborges on 9/8/16.
 */
public abstract class Account {

    private long amount;

    public Account (long amount) {
        this.amount = amount;
    }

    public long getAmount(){
        return amount;
    }

    public void deposit(long moneyin){
        amount = amount + moneyin;
    }

    public void setAmount(long moneyin){
        amount = moneyin;
    }

    public String toString() {
        return "Account Balance: $" + amount;
    }

    public static Account largerAccount(Account acc1, Account acc2) {
        if (acc1.getAmount() > acc2.getAmount()){
            return acc1;
        }else {return acc2;}
    }

}