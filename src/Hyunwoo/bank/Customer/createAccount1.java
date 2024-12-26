package org.example.bank.Customer;

import java.io.*;

public class createAccount1 {
    public CustomerDTO regist() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        CustomerDTO customerDTO = new CustomerDTO(2,1,"s","d");
        bw.write("사용하실 Id를 입력해주세요");
        bw.flush();
        int id = Integer.parseInt(br.readLine());
        customerDTO.setUser_id(id);

        bw.write("사용하실 password를 입력해 주세요");
        bw.flush();
        customerDTO.setPassword(Integer.parseInt(br.readLine()));

        bw.write("이름과 생년월일을 입력해 주세요\n");
        bw.flush();
        bw.write("이름");
        bw.flush();
        customerDTO.setName(br.readLine());
        bw.write("생년월일");
        bw.flush();
        customerDTO.setBirthDate(br.readLine());

        return customerDTO;
    }





}
