package Donggyu.src;

public class Customer {
    private String customerId;
    private String customerName;
    private Account[] accounts;
    private int accountCount;
    private static final int MAX_ACCOUNTS = 5;

    public Customer(String customerId, String customerName) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.accounts = new Account[MAX_ACCOUNTS];
        this.accountCount = 0;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void addAccount(Account account) {
        if (accountCount >= MAX_ACCOUNTS) {
            System.out.println("계좌 생성이 불가능합니다. 최대 계좌 수를 초과했습니다.");
            return;
        }

        accounts[accountCount++] = account;
        System.out.println("계좌가 생성되었습니다. 계좌 번호: " + account.getAccountNumber());
    }

    public Account findAccount(String accountNumber) {
        for (Account account : accounts) {
            if (account != null && account.getAccountNumber().equals(accountNumber)) {
                return account;
            }
        }
        return null;
    }
}
