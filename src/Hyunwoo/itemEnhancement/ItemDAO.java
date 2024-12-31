package org.example.itemEnhancement;

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

public class ItemDAO {

    MultiThreadExam.Enhance abc = new MultiThreadExam.Enhance();
    MultiThreadExam.EnhanceResult def = new MultiThreadExam.EnhanceResult();

    public List<ItemDTO> checkItem() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<ItemDTO> itemDTOList = new ArrayList<>();

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = DbUtil.getConnection();

            String sql = "select weoponLevel,armorLevel from level";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            if (rs.next()) {
                ItemDTO itemDTO = new ItemDTO(0, 0);
                itemDTO.setWeoponLevel(rs.getInt(1));
                itemDTO.setArmorLevel(rs.getInt(2));

                itemDTOList.add(itemDTO);

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            DbUtil.close(conn, ps, rs);
        }

        return itemDTOList;
    }

    public void EnhanceWeopon() throws IOException, SQLException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        int result = 0;
        try {
            conn = DbUtil.getConnection();
            String sql13 = "select weoponLevel from level";

            ps = conn.prepareStatement(sql13);
            rs = ps.executeQuery();

            int weoponLevel = 0;
            if (rs.next()) {
                weoponLevel = rs.getInt("weoponLevel");
            }

            if(weoponLevel==0 || weoponLevel==1 || weoponLevel==2) {
                abc.start();
                result = def.run(weoponLevel,10);
            }else if(weoponLevel==3 || weoponLevel==4 || weoponLevel==5){
                abc.start();
                result = def.run(weoponLevel,30);
            } else if (weoponLevel==6||weoponLevel==7) {
                abc.start();
                result = def.run(weoponLevel,60);
            }else if(weoponLevel==8||weoponLevel==9){
                abc.start();
                result = def.run(weoponLevel,80);
            } else if (weoponLevel==10) {
                abc.start();
                result = def.run(weoponLevel,90);
            }else{
                System.out.println("최고 단계입니다.");
                return;
            }

            String sql1 = "update level set weoponLevel = ?";
            ps = conn.prepareStatement(sql1);
            ps.setInt(1, result);
            ps.executeUpdate();

            ItemDTO itemDTO = new ItemDTO(0, 0);
            itemDTO.setWeoponLevel(result);
            System.out.println("무기 레벨: " + itemDTO.getWeoponLevel());

        } catch (SQLException e) {
            throw new RuntimeException(e);

        } finally {
            DbUtil.close(conn, ps, rs);
        }

    }

    public void EnhanceArmor() throws IOException, SQLException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        int result = 0;
        try {
            conn = DbUtil.getConnection();
            String sql13 = "select armorLevel from level";

            ps = conn.prepareStatement(sql13);
            rs = ps.executeQuery();

            int armorLevel = 0;
            if (rs.next()) {
                armorLevel = rs.getInt("armorLevel");
            }

            if(armorLevel==0 || armorLevel==1 || armorLevel==2) {
                abc.start();
                result = def.run(armorLevel,10);
            }else if(armorLevel==3 || armorLevel==4 || armorLevel==5){
                abc.start();
                result = def.run(armorLevel,30);
            } else if (armorLevel==6||armorLevel==7) {
                abc.start();
                result = def.run(armorLevel,50);
            }else if(armorLevel==8||armorLevel==9){
                abc.start();
                result = def.run(armorLevel,70);
            } else if (armorLevel==10) {
                abc.start();
                result = def.run(armorLevel,90);
            }else{
                System.out.println("최고 단계입니다.");
                return;
            }

            String sql1 = "update level set armorLevel = ?";
            ps = conn.prepareStatement(sql1);
            ps.setInt(1, result);
            ps.executeUpdate();

            ItemDTO itemDTO = new ItemDTO(0, 0);
            itemDTO.setArmorLevel(result);
            System.out.println("방어구 레벨: " +itemDTO.getArmorLevel());


        } catch (SQLException e) {
            throw new RuntimeException(e);

        } finally {
            DbUtil.close(conn, ps, rs);
        }
    }
}