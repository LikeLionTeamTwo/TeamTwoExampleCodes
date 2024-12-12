package Junho.실습문제.bankProject;


import Junho.실습문제.bankProject.exception.BankOperationException;

public class Bank {

    String name;
     Customer[] customers;
     int customerTop;

    public Bank(String name ) {
        this.customers = new Customer[100];
        this.name = name;
        this.customerTop = 0;
    }

    public void addCustomer(Customer customer) throws BankOperationException {

            for (int i = 0; i < this.customerTop; i++) {
                if(this.customers[i].name.equals(customer.name)){
                    throw new BankOperationException("중복된 아이디가 있습니다.");
                }
            }

        customers[customerTop++] = customer;
    }

    public Customer findCustomer (String id) throws BankOperationException {
        for (int i = 0; i < customerTop; i++) {
            if(customers[i].id.equals(id)){
                return customers[i];
            }
        }
        throw new BankOperationException("존재하지 않는 고객입니다.");
    }



}
