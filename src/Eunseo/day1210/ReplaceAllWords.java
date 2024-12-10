/*
실습 문제 2: 짝수와 홀수 판별기
사용자로부터 정수 하나를 입력받아, 그 수가 짝수인지 홀수인지 판별하는 프로그램을 작성하세요.
if-else 문을 사용하여 구현하세요.
 */

package Eunseo.day1210;

public class ReplaceAllWords {
    public String replaceAllWords(String original, String target, String replacement) {
        original = original.toLowerCase();
        original = original.replaceAll(target, replacement);
        return original;
    }

    public static void main(String[] args) {
        ReplaceAllWords rp = new ReplaceAllWords();
        System.out.println(rp.replaceAllWords("I like cat. Cat is cute.", "cat", "dog"));
    }
}