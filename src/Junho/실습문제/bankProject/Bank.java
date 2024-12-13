package Junho.실습문제.bankProject;


import Junho.실습문제.bankProject.exception.BankOperationException;

public class Bank {


    private String name;
    private Customer[] customers;
    private int customerTop;

    public Bank(String name ) {
        this.customers = new Customer[100];
        this.name = name;
        this.customerTop = 0;
    }

    public void addCustomer(Customer customer) throws BankOperationException {
        for (int i = 0; i < this.customerTop; i++) {
            if(this.customers[i].getName().equals(customer.getName())){
                throw new BankOperationException("중복된 아이디가 있습니다.");
            }
        }

        customers[customerTop++] = customer;
    }

    public Customer findCustomer (String id) throws BankOperationException {
        for (int i = 0; i < customerTop; i++) {
            if(customers[i].getId().equals(id)){
                return customers[i];
            }
        }
        throw new BankOperationException("존재하지 않는 고객입니다.");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Customer[] getCustomers() {
        return customers;
    }

    public void setCustomers(Customer[] customers) {
        this.customers = customers;
    }

    public int getCustomerTop() {
        return customerTop;
    }

    public void setCustomerTop(int customerTop) {
        this.customerTop = customerTop;
    }

}
