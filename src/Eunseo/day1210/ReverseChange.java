package Eunseo.day1210;

public class ReverseChange {
    public String reverseChange(String str) {
        String revString = "";
        for(int i = str.length() - 1; i >= 0; i--) {
            // 자바는 char를 자동으로 문자열로 변환한 뒤 결합하는 거 가능
            revString += str.charAt(i);
        }
        return revString;
    }

    public static void main(String[] args) {
        ReverseChange r = new ReverseChange();
        System.out.println(r.reverseChange("abc"));
        System.out.println(r.reverseChange("Hello"));
    }
}
