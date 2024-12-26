package org.example.bank.Customer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class CustomerTest {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        createAccount1 cr1 = new createAccount1();
        CustomerDTO customerDTO = new CustomerDTO(2,2,"s","d");
        CustomerDAO customerDAO = new CustomerDAO();
//        customerDTO.setUser_id(Integer.parseInt(br.readLine()));
//        System.out.println(customerDTO.getUser_id());

//        customerDAO.createAccount(customerDTO);

//        List<CustomerDTO> list = customerDAO.checkCustomer();
//        for(CustomerDTO dto : list){
//            System.out.println(dto);
//        }
//
//        customerDAO.update();


        //이제 customer 테이블의 user_id랑 account 테이블의 user_id랑 연동시켜야 함
    }
}
