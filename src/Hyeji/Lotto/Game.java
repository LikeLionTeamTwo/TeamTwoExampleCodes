package Hyeji.Lotto;

public enum Game {
    LOTTO,
    EXAMPLE;

    public Gameable asGameable() {
        Gameable game = null;

        switch (this) {
            case LOTTO -> game = new LottoGame();
            case EXAMPLE -> game = new ExampleGame();
        }
        return game;
    }

    public int asIndex() {
        int index = 0;

        switch (this) {
            case LOTTO -> index = 1;
            case EXAMPLE -> index = 2;
        }
        return index;
    }

    public String asGameName() {
        String name = "";

        switch (this) {
            case LOTTO -> name = "로또 게임";
            case EXAMPLE -> name = "기타";
        }
        
        return name;
    }
}
