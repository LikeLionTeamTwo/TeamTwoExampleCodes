package Donggyu.src;

public class Bank {
    private Customer[] customers;
    private int customerCount;
    private static final int MAX_CUSTOMERS = 100;

    public Bank() {
        customers = new Customer[MAX_CUSTOMERS];
        customerCount = 0;
    }

    public void addCustomer(Customer customer) {
        if (customerCount >= MAX_CUSTOMERS) {
            System.out.println("고객 등록이 불가능합니다. 최대 고객 수를 초과했습니다.");
            return;
        }

        for (Customer c : customers) {
            if (c != null && c.getCustomerId().equals(customer.getCustomerId())) {
                System.out.println("이미 등록된 ID입니다.");
                return;
            }
        }

        customers[customerCount++] = customer;
        System.out.println("고객 등록이 완료되었습니다.");
    }

    public Customer findCustomer(String customerId) {
        for (Customer customer : customers) {
            if (customer != null && customer.getCustomerId().equals(customerId)) {
                return customer;
            }
        }
        return null;
    }

    public Customer[] getCustomers() {
        return customers;
    }
}
