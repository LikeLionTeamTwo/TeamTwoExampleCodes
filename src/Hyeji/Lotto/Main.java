package Hyeji.Lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public final class Main {
    private final ArrayList<Gameable> games;
    private final Scanner scanner;

    public Main() {
        this.games = new ArrayList<>();
        this.scanner = new Scanner(System.in);
    }

    public static void main(String[] args) {
        Main main = new Main();
        main.startProgram();
    }

    public void startProgram() {
        setGames();
        try {
            int selectedGameIndex = (scanner.nextInt() - 1);
            Gameable selectedGame = games.get(selectedGameIndex - 1);
            selectedGame.startGame();
        } catch (IndexOutOfBoundsException e) {
            System.out.println("잘못된 번호를 선택했습니다. 프로그램을 종료합니다.");
        } catch (NumberFormatException e) {
            System.out.println("숫자를 입력해주세요. 프로그램을 종료합니다.");
        }
    }

    private void setGames() {
        for (Game game : Arrays.asList(Game.values())) {
            System.out.println(game.asIndex() + ". " + game.asGameName());
            games.add(game.asGameable());
        }
        System.out.print("원하는 게임 번호를 입력하세요.: ");
    }
}
