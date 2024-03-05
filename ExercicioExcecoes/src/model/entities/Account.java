package model.entities;

import model.exceptions.AccountException;

public class Account {
    private final Integer number;
    private String holder;
    private Double balance;
    private Double withdrawLimit;

    public Account(Integer number, String holder, Double amount, Double withdrawLimit){
        this.number = number;
        this.holder = holder;
        balance = 0.0;
        deposit(amount);
        this.withdrawLimit = withdrawLimit;
    }

    public Integer getNumber() {
        return number;
    }

    public String getHolder() {
        return holder;
    }

    public void setHolder(String holder) {
        this.holder = holder;
    }

    public Double getBalance() {
        return balance;
    }

    public Double getWithdrawLimit() {
        return withdrawLimit;
    }

    public void setWithdrawLimit(Double withdrawLimit) {
        this.withdrawLimit = withdrawLimit;
    }

    public void deposit(Double amount){
        balance += amount;
    }

    public void withdraw(Double amount) throws AccountException {
        if(amount > balance){
            throw new AccountException("Withdraw error: Not enough balance!");
        }
        if(amount > withdrawLimit){
            throw new AccountException("Withdraw error: The amount exceeds withdraw limit!");
        }
        balance -= amount;
    }
}
