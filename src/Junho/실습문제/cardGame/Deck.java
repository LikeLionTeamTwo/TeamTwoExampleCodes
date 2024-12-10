package Junho.실습문제.cardGame;

import java.util.Random;

public class Deck {

    private Card[] cards;
    private int top;

    public Deck (){
        cards = new Card[52];
        top = cards.length-1;
        int idx = 0;
        for (int i = 0; i < Card.cardTypes.length ;i++) {
            for (int j = 0; j < 13; j++) {
                cards[idx] = new Card(j + 1, Card.cardTypes[i]);
                idx++;
            }
        }
    }
    public void shuffle(){
        Random random = new Random();
        for (int i = cards.length-1; i > 0; i--) {
            int randomIndex = random.nextInt(i + 1);
            Card temp = cards[i];
            cards[i] = cards[randomIndex];
            cards[randomIndex] = temp;
        }

    }

    public Card draw(){
        Card drawCard = cards[top];
        cards[top--] =null;
        return drawCard;
    }


}
