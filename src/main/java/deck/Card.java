package deck;

public class Card {

	String rank;
	String suit;
	String simbol;
	int value;

	public Card(String rank, String suit) {
		this.rank = rank;
		this.suit = suit;
		if (suit.equals(Suit.HEARTS.toString())) {
			simbol = "♥";
		} else if (suit.equals(Suit.DIAMONDS.toString())) {
			simbol = "♦";
		} else if (suit.equals(Suit.CLUBS.toString())) {
			simbol = "♣";
		} else if (suit.equals(Suit.SPADES.toString())) {
			simbol = "♠";
		} else {
			simbol = "";
		}
	}

	@Override
	public String toString() {
		return rank + " of " + suit;
	}

	public String getRank() {
		return rank;
	}

	public void setRank(String rank) {
		this.rank = rank;
	}

	public String getSuit() {
		return suit;
	}

	public void setSuit(String suit) {
		this.suit = suit;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public String getSimbol() {
		return simbol;
	}

	public void setSimbol(String simbol) {
		this.simbol = simbol;
	}


}
