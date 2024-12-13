package Junho.실습문제.bankProject;


import Junho.실습문제.bankProject.exception.AccountNotFoundException;
import Junho.실습문제.bankProject.exception.BankOperationException;
public class Customer {
    private String id;
    private String name;
    private Account[] accounts;
    private int top = 0;
    private static final int MAX_ACCOUNT_COUNT = 5;

    public Customer(String id, String name) {
        this.id = id;
        this.name = name;
        this.accounts = new Account[MAX_ACCOUNT_COUNT];
    }

    //최대 계좌 5개
    public void addAccount(Account account) throws BankOperationException {
        if(top > 4) {
            throw new BankOperationException("계좌 최대 개수를 초과합니다.");
        }
        accounts[top++] = account;
    }

    public Account findAccount(int accountNumber) throws AccountNotFoundException{
        for (int i = 0; i < top; i++) {
            if(accounts[i].getAccountNumber() == accountNumber){
                return accounts[i];
            }
        }
        throw new AccountNotFoundException("계좌를 찾지 못했습니다.");
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Account[] getAccounts() {
        return accounts;
    }

    public void setAccounts(Account[] accounts) {
        this.accounts = accounts;
    }

    public int getTop() {
        return top;
    }

    public void setTop(int top) {
        this.top = top;
    }
}