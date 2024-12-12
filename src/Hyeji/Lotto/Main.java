package Hyeji.Lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static ArrayList<Gameable> games = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Main.startProgram();
    }

    public static void startProgram() {
        setGames();
        Gameable selectedGame = games.get(scanner.nextInt() - 1);
        selectedGame.startGame();
    }

    private static void setGames() {
        for (Game game : Arrays.asList(Game.values())) {
            System.out.print(game.asIndex() + ". " + game.asGameName() + "\n");
            games.add(game.asGameable());
        }
        System.out.print("원하는 게임 번호를 입력하세요.: ");
    }
}
