package org.example.bank.Bank;

import org.example.bank.Customer.CustomerDAO;
import org.example.bank.Customer.CustomerDTO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.List;

public class BankUser {
    public static void main(String[] args) throws IOException, SQLException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            BankDTO bankDTO = new BankDTO();
            BankDAO2 bankDAO = new BankDAO2();
            CustomerDTO customerDTO = new CustomerDTO();
            CustomerDAO customerDAO = new CustomerDAO();
            System.out.println("1.입금 2.출금 3.등록 4.찾기 5.수정");
            int select = Integer.parseInt(br.readLine());
            switch (select) {
                case 1:
                    bankDAO.deposit();
                    break;
                case 2:
                    bankDAO.withDraw();
                    break;
                case 3:
                    customerDAO.createAccount(customerDTO);
                    break;
                case 4:
                    List<CustomerDTO> list = customerDAO.checkCustomer();
                    for(CustomerDTO dto : list){
                        System.out.println(dto);
                    }
                    break;
                case 5:
                    customerDAO.update();
                    break;
            }

        }
    }
}
