package deck;

public enum Value {

    ONE(1, "A"),
    TWO(2, "2"),
    THREE(3, "3"),
    FOUR(4, "4"),
    FIVE(5, "5"),
    SIX(6, "6"),
    SEVEN(7, "7"),
    EIGHT(8, "8"),
    NINE(9, "9"),
    TEN(10, "10"),
    ELEVEN(11, "J"),
    TWELVE(12, "Q"),
    THIRTEEN(13, "K");

    private final int number;
    private final String display;

    Value(int number, String display) {
        this.number = number;
        this.display = display;
    }

    public int getNumber() {
        return number;
    }

    public String getDisplay() {
        return display;
    }

    @Override
    public String toString() {
        return display;
    }
}
