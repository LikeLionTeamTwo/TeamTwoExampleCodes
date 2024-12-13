package BankProject;

public class Customer {
    private String id;
    private String name;
    private Account[] accounts;
    private int accountCount;
    private final int MAX_ACCOUNTS = 5;

    public Customer(String id, String name) {
        this.id = id;
        this.name = name;
        this.accounts = new Account[MAX_ACCOUNTS];
        this.accountCount = 0;
    }
    public String getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public Account[] getAccounts() {
        return accounts;
    }
    public void addAccount(Account account) throws BankOperationException {
        if (accountCount >= MAX_ACCOUNTS) {
            throw new BankOperationException("The maximum of account is" + MAX_ACCOUNTS + ".");
        }
        accounts[accountCount++] = account;
    }

    public Account findAccount(String accountNumber) throws AccountNotFoundException {
        for (int i = 0; i < accountCount; i++) {
            if (accounts[i].getAccountNumber().equals(accountNumber)) {
                return accounts[i];
            }
        }
        throw new AccountNotFoundException("Cannot find the account: " + accountNumber);
    }
}
