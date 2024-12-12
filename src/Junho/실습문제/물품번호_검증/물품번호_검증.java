package Junho.실습문제.물품번호_검증;

public class 물품번호_검증 {
    boolean checkProductNumber(String productNumber){
        if(productNumber.length() != 6) return false;
        if(!Character.isLetter(productNumber.charAt(0)) || !Character.isLetter(productNumber.charAt(1))) return  false;
        for (int i = 2; i < 6; i++) {
            if(!Character.isDigit(productNumber.charAt(i))){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        물품번호_검증 물품번호_검증 = new 물품번호_검증();
        System.out.println( 물품번호_검증.checkProductNumber("test56"));
    }

}
