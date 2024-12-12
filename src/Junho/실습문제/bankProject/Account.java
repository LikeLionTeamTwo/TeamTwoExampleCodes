package Junho.실습문제.bankProject;


import Junho.실습문제.bankProject.exception.InvalidTransactionException;

public class Account {
    int accountNumber;
    String customerId;
    int balance;
    int limit;

    //입금과 출금

    //입금
    public void deposit(int money) throws InvalidTransactionException {
        // 잘못된 금액 또는 잔액 부족 시 예외를 발생시킵니다.
        if(balance + money <= limit) balance += money;
        else throw new InvalidTransactionException("최대 잔액 한도를 넘었습니다. 최대 잔액 한도는 : " + limit + " 입니다.");
    }
    public int withdrawal(int money) throws InvalidTransactionException {
        if(balance < money) {
            throw  new InvalidTransactionException("잔액이 부족합니다.");
        }
        balance -= money;
        return balance;
    }

    public Account(int accountNumber, String customerId) {
        this.accountNumber = accountNumber;
        this.customerId = customerId;
        this.balance = 0;
        this.limit = 1000000;

    }
}
