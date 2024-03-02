package entities;

public class Account {
    private int number;
    private String holder;
    private double balance;

    public Account(int number, String holder, double initialDeposit){
        this.number = number;
        this.holder = holder;
        balance = initialDeposit;
    }

    public Account(int number, String holder){
        this.number = number;
        this.holder = holder;
    }

    public void deposit(double value){
        balance += value;
    }

    public void withdraw(double value){
        balance -= value + 5.00;
    }

    public String toString(){
        return "Account " + number + ", Holder: " + holder + ", Balance: $ " + String.format("%.2f",balance);
    }

    public int getNumber(){
        return number;
    }

    public String getHolder(){
        return holder;
    }

    public void setHolder(String newName){
        holder = newName;
    }

    public double getBalance(){
        return balance;
    }


}
