package org.example.bank.Bank;

public class BankDTO {
    int user_id;
    String name;
    int balance;
    int depositMoney;
    int withDrawMoney;

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public int getDepositMoney() {
        return depositMoney;
    }

    public void setDepositMoney(int depositMoney) {
        this.depositMoney = depositMoney;
    }

    public int getWithDrawMoney() {
        return withDrawMoney;
    }

    public void setWithDrawMoney(int withDrawMoney) {
        this.withDrawMoney = withDrawMoney;
    }

    @Override
    public String toString() {
        return "BankDTO{" +
                "user_id=" + user_id +
                ", name='" + name + '\'' +
                ", balance=" + balance +
                ", depositMoney=" + depositMoney +
                ", withDrawMoney=" + withDrawMoney +
                '}';
    }
}
