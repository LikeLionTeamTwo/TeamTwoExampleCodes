/*
문자열 내에 포함된 숫자(0~9)들을 모두 찾아 그 합을 구하여 반환하는 메소드를 작성하세요.
- 메소드명: sumOfDigits(String str)
- 반환타입: int

예시:
sumOfDigits("abc123") -> 6  (1+2+3 = 6)
sumOfDigits("a1b2c3d9") -> 15 (1+2+3+9 = 15)

힌트:
Character.isDigit() 메서드로 숫자 판별
문자를 숫자로 변환할 때는 Character.getNumericValue() 활용
 */

package Eunseo.day1210;

public class SumOfDigits {
    public int sumOfDigits(String str){
        int sum = 0;
        for(int i=0; i<str.length(); i++){
            if(Character.isDigit(str.charAt(i))) {
                sum+=Character.getNumericValue(str.charAt(i));
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        SumOfDigits s = new SumOfDigits();
        System.out.println(s.sumOfDigits("123"));
    }

}
