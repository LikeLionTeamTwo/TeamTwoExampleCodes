package Junho.실습문제.bankProject;


import Junho.실습문제.bankProject.exception.AccountNotFoundException;
import Junho.실습문제.bankProject.exception.BankOperationException;

public class Customer {
    String id;
    String name;
    Account[] accounts;

    int top = 0;

    public Customer(String id, String name) {
        this.id = id;
        this.name = name;
        this.accounts = new Account[5];
    }

    //최대 계좌 5개
    public void addAccount(Account account) throws BankOperationException {
        if(top > 4) {
            throw new BankOperationException("계좌 최대 개수를 초과합니다.");
        }
        accounts[top++] = account;
    }

    public Account findAccount(int accountNumber) throws AccountNotFoundException {
        for (int i = 0; i < top; i++) {
            if(accounts[i].accountNumber == accountNumber){
                return accounts[i];
            }
        }
        throw new AccountNotFoundException("계좌를 찾지 못했습니다.");
    }

}
