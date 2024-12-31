package org.example.itemEnhancement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.List;

public class Test {
    public static void main(String[] args) throws IOException, SQLException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ItemDAO itemDAO = new ItemDAO();

        List<ItemDTO> list = itemDAO.checkItem();
        for(ItemDTO dto : list){
            System.out.println(dto);
        }

        System.out.println("강화할 아이템을 선택해 주세요 (확률 0~2강:90% | 3~5강:70% | 6~7강:40% | 8~9강:20% | 10강:10%)");
        System.out.println("1.무기  2.방어구");
        int select = Integer.parseInt(br.readLine());
        switch (select){
            case 1 :
                itemDAO.EnhanceWeopon();
                break;

            case 2 :
                itemDAO.EnhanceArmor();
                break;
        }

//        abc.start();
//        def.start();
    }
}
