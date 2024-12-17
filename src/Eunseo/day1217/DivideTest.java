package Eunseo.day1217;
import java.util.Scanner;

public class DivideTest {
    public static void main(String[] args) {
        // 두 개 정수 입력받기
        Scanner scanner = new Scanner(System.in);
        System.out.print("첫 번째 정수를 입력하세요: ");
        int a = scanner.nextInt();
        System.out.print("두 번째 정수를 입력하세요: ");
        int b = scanner.nextInt();

        try {
            // a를 b로 나누어보기
            int result = a / b;
            System.out.println("결과: " + result);
            // 0으로 나누는 상황에서 arithmeticException 자동 발생
            //Java 런타임이 이 상황을 감지하고 예외를 던짐
        } catch (ArithmeticException e) {
            System.out.println("0으로 나눌 수 없습니다.");
        }

        scanner.close();
    }
}