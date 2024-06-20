package main.java;

public class Account {
    private String name;
    private int balance;

    public Account(String name, int balance){
        this.name = name;
        this.balance = balance;
    }

    public int getBalance(){
        return balance;
    }

    public void withdraw(int amount){
        if(balance >= amount){
            System.out.println(Thread.currentThread().getName() + " is going to withdraw " + amount);
            balance -= amount;
            System.out.println(Thread.currentThread().getName() + " completes the withdrawal of " + amount);
        }
        else{
            System.out.println(Thread.currentThread().getName() + " tried to withdraw " + amount + " but insufficient balance.");
        }
        System.out.println("Current balance: " + balance);
    }
}
