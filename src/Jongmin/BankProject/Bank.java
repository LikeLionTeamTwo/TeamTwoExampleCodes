package BankProject;

public class Bank {
    private Customer[] customers;
    private int customerCount;

    public void addCustomer(Customer customer) throws BankOperationException{
        for(int i = 0; i < customerCount; i++){
            if(customers[i].getId().equals(customer.getId())){
                throw new BankOperationException("Already enrolled customer ID");
            }
        }
        customers[customerCount++] = customer;
    }
    public Customer findCustomer(String id) throws AccountNotFoundException{
        for(int i = 0; i < customerCount; i++){
            if(customers[i].getId().equals(id)){
                return customers[i];
            }
        }
        throw new AccountNotFoundException("Cannot find customer");
    }
    public Account findAccount(String accountNumber) throws AccountNotFoundException{
        for(int i = 0; i < customerCount; i++){
            for(Account account : customers[i].getAccounts()){
                if(account.getAccountNumber().equals(accountNumber)){
                    return account;
                }
            }
        }
        throw new AccountNotFoundException("Cannot find account");
    }
}
