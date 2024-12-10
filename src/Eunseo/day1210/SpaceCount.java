package Eunseo.day1210;

public class SpaceCount {
    public int spaceCount(String str){
        int cnt = 0;
        for(char c : str.toCharArray()){
            if(Character.isWhitespace(c)){
                cnt++;
            }
        }
        return cnt;
    }

    public int alphaCount(String str){
        int cnt = 0;
        for(char c : str.toCharArray()){
            if(Character.isLetter(c)){
                cnt++;
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        SpaceCount sc = new SpaceCount();
        System.out.println(sc.spaceCount("test tset ts ttt"));
        System.out.println(sc.alphaCount("test tset ts ttt"));
    }
}
