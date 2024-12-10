package Eunseo.day1210;

public class CheckProductNumber {
    public boolean checkProductNumber(String productNumber) {
        if(productNumber.length()!=6){
            System.out.println("물품번호 길이는 6자리여야 합니다!");
            return false;
        }else if(Character.isLetter(productNumber.charAt(0))==false || Character.isLetter(productNumber.charAt(1))==false){
            return false;
        } else {
            for(int i=2;i<productNumber.length();i++){
                if(Character.isDigit(productNumber.charAt(i))==false){
                    return false;
                }
            }
        }
        // 위 조건들에 해당한다면 return 실행 뒤 즉시 종료하므로 여기까지 오지 않는다.
        return true;
    }

    public static void main(String[] args) {
        CheckProductNumber checkPNum = new CheckProductNumber();
        System.out.println(checkPNum.checkProductNumber("te3456"));
        System.out.println(checkPNum.checkProductNumber("t33456"));
    }
}
