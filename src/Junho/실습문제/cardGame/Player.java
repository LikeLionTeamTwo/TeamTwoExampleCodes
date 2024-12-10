package Junho.실습문제.cardGame;

public class Player {
    String name;
    int score;

    public Player(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public void addScore(int points){
        score += points;
    }

}
