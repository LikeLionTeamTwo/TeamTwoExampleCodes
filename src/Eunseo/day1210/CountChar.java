package Eunseo.day1210;

public class CountChar {
    public int countChar(String str, char c) {
        int cnt = 0;
        for(int i=0; i<str.length(); i++){
            // char 값 비교에는 '==' 사용
            if(str.charAt(i)== c) {
                cnt++;
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        CountChar cc = new CountChar();
        System.out.println(cc.countChar("banana", 'a'));
    }
}
