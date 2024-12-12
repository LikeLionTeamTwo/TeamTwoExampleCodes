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
        System.out.print("1. 로또 게임\n2. 기타\n원하는 게임 번호를 입력하세요.: ");
        Gameable selectedGame = games.get(scanner.nextInt() - 1);

        selectedGame.startGame();
    }

    private static void setGames() {
        Arrays.asList(Game.values()).forEach(
                game -> games.add(game.asGameable())
        );
    }
}
