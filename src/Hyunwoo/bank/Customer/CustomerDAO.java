package org.example.bank.Customer;

import org.example.bank.DbUtil;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerDAO {
    //crud
    public void createAccount(CustomerDTO customerDTO){

        Connection conn = null;
        PreparedStatement ps = null;
        String sql = "insert into customer(user_id,password,name,birthDate) values(?,?,?,?)";
        try{
            conn = DbUtil.getConnection();
            ps = conn.prepareStatement(sql);
            createAccount1 cr1 = new createAccount1();
            customerDTO = cr1.regist();
            ps.setInt(1,customerDTO.getUser_id());
            ps.setInt(2,customerDTO.getPassword());
            ps.setString(3,customerDTO.getName());
            ps.setString(4,customerDTO.getBirthDate());
            ps.executeUpdate();

            String sql1 = "insert into account (user_id,name,balance) values(?,?,?)";
            ps = conn.prepareStatement(sql1);
            ps.setInt(1,customerDTO.getUser_id());
            ps.setString(2,customerDTO.getName());
            ps.setString(3,"0");
            ps.executeUpdate();

            System.out.println("등록이 완료 되었습니다.");
        }catch (SQLException | IOException e){
            throw new RuntimeException(e);
        }finally {
            DbUtil.close(conn,ps);
        }
    }

    public List<CustomerDTO> checkCustomer()throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<CustomerDTO> customerDTOList = new ArrayList<>();

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = DbUtil.getConnection();

            String sql = "select user_id,name,birthDate from customer where user_id=?";
            ps = conn.prepareStatement(sql);
            System.out.println("찾으실 id를 입력해 주세요");
            int id = Integer.parseInt(br.readLine());
            ps.setInt(1,id);
            rs = ps.executeQuery();
            if(rs.next()){
                CustomerDTO customerDTO = new CustomerDTO();
                customerDTO.setUser_id(rs.getInt(1));
                customerDTO.setName(rs.getString(2));
                customerDTO.setBirthDate(rs.getString(3));

                customerDTOList.add(customerDTO);

            }
        }catch (SQLException | IOException e){
            throw new RuntimeException(e);
        }finally {
            DbUtil.close(conn,ps,rs);
        }

        return customerDTOList;
    }

    public void update()throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql5 = "select user_id from customer";
        try {
            conn = DbUtil.getConnection();
            ps = conn.prepareStatement(sql5);
            rs = ps.executeQuery();
            int id = 0;
            int id1 = 0;
                System.out.println("id를 입력해 주세요");
                id = Integer.parseInt(br.readLine());

                while (rs.next()) {
                    id1 = rs.getInt("user_id");
                }

            System.out.println("수정할 번호를 입력해주세요");
            System.out.println("1.id 2.비밀번호 3.이름 4.생년월일");
            int select = Integer.parseInt(br.readLine());
            switch (select) {
                case 1 :
                    String sql = "update customer set user_id=? where user_id=?";
                    ps = conn.prepareStatement(sql);
                    System.out.println("변경할 id를 입력해 주세요");
                    int id10 = Integer.parseInt(br.readLine());
                    ps.setInt(2,id);
                    ps.setInt(1,id10);
                    ps.executeUpdate();
                    break;
                case 2 :
                    String sql1 = "update customer set password=? where user_id=?";
                    ps = conn.prepareStatement(sql1);
                    System.out.println("변경할 비밀번호를 입력해 주세요");
                    int password = Integer.parseInt(br.readLine());
                    ps.setInt(2,id);
                    ps.setInt(1,password);
                    ps.executeUpdate();
                    break;
                case 3 :
                    String sql2 = "update customer set name=? where user_id=?";
                    ps = conn.prepareStatement(sql2);
                    System.out.println("변경할 이름을 입력해 주세요");
                    int name = Integer.parseInt(br.readLine());
                    ps.setInt(2,id);
                    ps.setInt(1,name);
                    ps.executeUpdate();
                    break;
                case 4 :
                    String sql3 = "update customer set birthDate=? where user_id=?";
                    ps = conn.prepareStatement(sql3);
                    System.out.println("변경할 생년월일을 입력해 주세요");
                    int birthDate = Integer.parseInt(br.readLine());
                    ps.setInt(2,id);
                    ps.setInt(1,birthDate);
                    ps.executeUpdate();
                    break;
            }
        }catch (SQLException | IOException e){
            throw new RuntimeException(e);
        }finally {
            DbUtil.close(conn,ps);
        }

    }
}
