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
        printIntro();
        Gameable selectedGame = games.get(scanner.nextInt() - 1);
        selectedGame.startGame();
    }

    private static void printIntro() {
        Arrays.asList(Game.values()).forEach(
                game -> System.out.print(game.asIndex() + ". " + game.asGameName() + "\n")
        );
        System.out.print("원하는 게임 번호를 입력하세요.: ");
    }

    private static void setGames() {
        Arrays.asList(Game.values()).forEach(
                game -> games.add(game.asGameable())
        );
    }
}
