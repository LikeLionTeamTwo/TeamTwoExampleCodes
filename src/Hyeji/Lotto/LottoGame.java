package Hyeji.Lotto;

import java.util.Scanner;

public class LottoGame implements Gameable {
    Scanner scanner = new Scanner(System.in);
    LottoGenerator generator = new LottoGenerator();

    public static void main(String[] args) {}

    @Override
    public void startGame() {
        System.out.print("얼마 해 드려요?: ");
        int money = scanner.nextInt();

        verifyPurchase(money);
    }

    private void verifyPurchase(int money) {
        if (money < 1000) {
            System.out.println("돈이 부족한디?");
        } else {
            printResult(money);
        }
    }

    private String generateLottoNumbers(int gameCount) {
        String result = "";

        for (int i = 1; i <= gameCount; i++) {
            LottoBall[] tempLottoBalls = generator.getSixLottoBalls();
            result = result + i + "게임: ";

            for (int j = 0; j < tempLottoBalls.length; j++) {
                result = j == 5
                        ? result + tempLottoBalls[j].getNumber()
                        : result + tempLottoBalls[j].getNumber() + ", " ;
            }

            result = i == gameCount
                    ? result
                    : result + "\n";
        }
        return result;
    }

    private void printResult(int money) {
        int gameCount = money / 1000;
        int change = money % 1000;

        System.out.println("게임 수: " + gameCount + " " + "거스름 돈: " + change);
        System.out.print(generateLottoNumbers(gameCount));
    }
}
