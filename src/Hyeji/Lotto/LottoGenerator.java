package Hyeji.Lotto;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

public class LottoGenerator {

    private LottoBall[] lottoBalls;

    public static void main(String[] args) {
        System.out.println();
    }

    public LottoGenerator() {
        createLottoBalls();
    }

    private void createLottoBalls() {
        LottoBall[] tempLottoBalls = new LottoBall[45];

        IntStream.rangeClosed(1, 45).forEach( i -> {
            tempLottoBalls[i - 1] = new LottoBall(i);
        });

        lottoBalls = tempLottoBalls;
    }

    private LottoBall[] shuffleLottoBalls(LottoBall[] array) {
        Random random = new Random();
        for (int i = array.length - 1; i > 0; i--) {
            int j = random.nextInt(i + 1);

            LottoBall temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }

        return array;
    }

    public LottoBall[] getSixLottoBalls() {
        LottoBall[] tempLottoBalls = shuffleLottoBalls(lottoBalls);
        return Arrays.copyOfRange(tempLottoBalls, 0, 6);
    }
}