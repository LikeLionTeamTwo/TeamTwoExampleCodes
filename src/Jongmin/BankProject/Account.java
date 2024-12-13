package BankProject;

public class Account {
    private String accountNumber;
    private double balance;

    public Account(String accountNumber, double initialBalance) {
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) throws InvalidTransactionException {
        if (amount <= 0) {
            throw new InvalidTransactionException("Deposit must be a positive number");
        }
        balance += amount;
    }

    public void withdraw(double amount) throws InvalidTransactionException {
        if (amount <= 0) {
            throw new InvalidTransactionException("Withdraw must be a positive number");
        }
        if (balance < amount) {
            throw new InvalidTransactionException("Not enough money to withdraw");
        }
        balance -= amount;
    }
}
