package Junho.실습문제.cardGame;

import java.util.Map;

public class Card {

    public static final String[] cardTypes = {"Spades","Hearts", "Diamonds", "Clubs"};
    public static final   Map<String,Integer> cardMap = Map.of(
            "Spades", 4,
            "Hearts", 3,
            "Diamonds", 2,
            "Clubs", 1
    );
    int number;
    String suit;

    public Card(int number, String suit) {
        this.number = number;
        this.suit = suit;
    }
}
