package org.example;

public class Bank_Account_System {
    private int balance;

    public Bank_Account_System(int balance) {
        this.balance = balance;
    }

    public Bank_Account_System() {
        this(0);
    }

    public int deposit(int amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("Invalid amount");
        }
        this.balance += amount;
        return this.balance;
    }

    public int withdraw(int amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("Invalid amount");
        }
        if (amount > this.balance) {
            throw new IllegalArgumentException("Insufficient balance.");
        }
        this.balance -= amount;
        return this.balance;
    }

    public int viewBalance() {
        return this.balance;
    }

    public void transfer(Bank_Account_System otherAccount, int amount) {
        this.withdraw(amount);
        otherAccount.deposit(amount);
    }

    public static void main(String[] args) {
        Bank_Account_System account1 = new Bank_Account_System();
        Bank_Account_System account2 = new Bank_Account_System();
        account1.deposit(1000);
        account1.transfer(account2, 300);
        System.out.println("account1.balance = " + account1.viewBalance());
        System.out.println("account2.balance = " + account2.viewBalance());
    }
}