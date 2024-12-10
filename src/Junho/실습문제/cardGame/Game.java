package Junho.실습문제.cardGame;

public class Game {
    Player[] players;
    Deck deck;

    int rounds;

    public Game(Player[] players, Deck deck) {
        this.players = players;
        this.deck = deck;
        this.rounds = 5;
    }

    public void start(){
        deck.shuffle();
        System.out.println("게임을 시작합니다.");
        for (int i = 1; i <= rounds; i++) {
            System.out.print("Round " + i + ": ");
            Card draw1 = deck.draw();
            System.out.println(players[0].name + " draws " + draw1.number + " of " + draw1.suit);

            Card draw2 = deck.draw();
            System.out.println("\t \t " + players[1].name + " draws " + draw2.number + " of " + draw2.suit);
            Player winPlayer;
            if(draw1.number > draw2.number) winPlayer = players[0];
            else if (draw1.number < draw2.number) winPlayer = players[1];
            else if (Card.cardMap.get(draw1.suit) > Card.cardMap.get(draw2.suit) ) winPlayer = players[0];
            else winPlayer = players[1];
            System.out.println("승자는 : " + winPlayer.name);
            System.out.println();
            winPlayer.score++;
        }
    }
    public static void main(String[] args) {
        Player player1 = new Player("player1", 0);
        Player player2 = new Player("player2", 0);

        Player[] players = new Player[2];
        players[0] = player1;
        players[1] = player2;
        Deck deck = new Deck();
        Game game = new Game(players, deck);

        game.start();
    }
}
