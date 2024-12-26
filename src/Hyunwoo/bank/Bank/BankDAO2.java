package org.example.bank.Bank;

import org.example.bank.DbUtil;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BankDAO2 {

    public BankDTO deposit() throws IOException, SQLException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BankDTO bankDTO = new BankDTO();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = DbUtil.getConnection();

            System.out.println("입금할 id를 입력해 주세요");
            int id = Integer.parseInt(br.readLine());
            String sql13 = "select user_id from account where user_id=?";

            ps = conn.prepareStatement(sql13);
            ps.setInt(1,id);
            rs = ps.executeQuery();
            if(rs.next()){
                int id123 = rs.getInt("user_id");
            }else {
                throw new UserNotFoundException("사용자를 찾을 수 없습니다. 입력한 ID가 잘못되었거나 존재하지 않습니다.");
            }

            System.out.println("입금할 금액을 입력해 주세요");
            int mon = Integer.parseInt(br.readLine());
            String sql = "select balance from account where user_id  = ?";

            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            int balance = 0;
            if (rs.next()) {
                balance = rs.getInt("balance");
            }
            balance += mon;  // Add deposit amount to current balance

            String sql1 = "update account set balance = ?, depositMoney = ?, withDrawMoney = 0 where user_id = ?";
            ps = conn.prepareStatement(sql1);
            ps.setInt(1, balance);
            ps.setInt(2, mon);
            ps.setInt(3, id);
            ps.executeUpdate();
            System.out.println("입금이 완료되었습니다.");

            bankDTO.setUser_id(id);
            bankDTO.setBalance(balance);
            bankDTO.setDepositMoney(mon);

        } catch (SQLException | IOException e) {
            throw new RuntimeException(e);
        } catch (UserNotFoundException e) {

            System.out.println(e.getMessage());
            return null;
        } finally {
            DbUtil.close(conn, ps, rs);
        }

        return bankDTO;
    }


    public BankDTO withDraw() throws IOException, SQLException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BankDTO bankDTO = new BankDTO();

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "select balance from account where user_id  = ?";
        try {
            System.out.println("출금할 id를 입력해 주세요");
            int id = Integer.parseInt(br.readLine());
            System.out.println("출금할 금액을 입력해 주세요");
            int mon = Integer.parseInt(br.readLine());

            conn = DbUtil.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1,id);
            rs = ps.executeQuery();

            int balance = 0;
            while (rs.next()) {
                balance = rs.getInt("balance");
            }
            balance = balance - mon;
            String sql1 = "update account set balance = ?,withDrawMoney = ?,depositMoney = 0 where user_id = ?";

            ps = conn.prepareStatement(sql1);
            ps.setInt(1, balance);
            ps.setInt(2, mon);
            ps.setInt(3, id);
            ps.executeUpdate();


        }catch (SQLException | IOException e){
            throw new RuntimeException(e);
        }finally {
            DbUtil.close(conn,ps,rs);
        }

        return bankDTO;
    }
}
