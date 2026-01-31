package deck;

import java.util.Objects;

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
	
	public Card(String rank, String suit, int value) {
		this.rank = rank;
		this.suit = suit;		
		this.value = value;
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

	@Override
	public int hashCode() {
		return Objects.hash(rank, simbol, suit, value);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Card other = (Card) obj;
		return Objects.equals(rank, other.rank) && Objects.equals(simbol, other.simbol)
				&& Objects.equals(suit, other.suit) && value == other.value;
	}


	
	
}
