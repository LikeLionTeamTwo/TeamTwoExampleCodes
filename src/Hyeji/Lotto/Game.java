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
}
