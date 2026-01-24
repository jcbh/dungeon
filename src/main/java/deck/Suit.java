package deck;

public enum Suit {

    HEARTS("♥", Constants.HEARTS),
    DIAMONDS("♦", Constants.DIAMONDS),
    CLUBS("♣", Constants.CLUBS),
    SPADES("♠", Constants.SPADES);

    private final String symbol;
    private final String name;

    Suit(String symbol, String name) {
        this.symbol = symbol;
        this.name = name;
    }

    public String getSymbol() {
        return symbol;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return symbol + " " + name;
    }
}