package deck;

import java.util.List;

public class Deck {

	List<Card> cards;

	public Deck() {
		cards = new java.util.ArrayList<Card>();
		
		for (Suit suit : Suit.values()) {
			for (Value value : Value.values()) {
				cards.add(new Card(value.toString(), suit.toString()));
			}
		}
	}
	
	public void shuffle() {
		java.util.Collections.shuffle(cards);
	}

	public List<Card> getCards() {
		return cards;
	}

	public void setCards(List<Card> cards) {
		this.cards = cards;
	}
	
	public void removeDugeonCard() {
		List<Card> cardsToRemove = List.of(
			    new Card(Value.ONE.toString(), Suit.DIAMONDS.toString()),
			    new Card(Value.ELEVEN.toString(), Suit.DIAMONDS.toString()),
			    new Card(Value.TWELVE.toString(), Suit.DIAMONDS.toString()),
			    new Card(Value.THIRTEEN.toString(), Suit.DIAMONDS.toString()),
			    new Card(Value.ONE.toString(), Suit.HEARTS.toString()),
			    new Card(Value.ELEVEN.toString(), Suit.HEARTS.toString()),
			    new Card(Value.TWELVE.toString(), Suit.HEARTS.toString()),
			    new Card(Value.THIRTEEN.toString(), Suit.HEARTS.toString())
			);

		cards.removeAll(cardsToRemove);
	}
	
	public Deck generateDungeonDeck() {
		removeDugeonCard();
		shuffle();
		return this;
	}
	
	public List<Card> drawCards(int numberOfCards) {
		if (numberOfCards > cards.size()) {
			numberOfCards = cards.size();
		}
		List<Card> drawnCards = new java.util.ArrayList<Card>(cards.subList(0, numberOfCards));
		cards.subList(0, numberOfCards).clear();
		
		cards.removeAll(drawnCards);
		
		return drawnCards;
	}

	public static void main(String[] args) {
		Deck deck = new Deck();	
		System.out.println(deck.getCards());
		System.out.println("Total cards: " + deck.getCards().size());
		
		deck.generateDungeonDeck();
		System.out.println(deck.getCards());
		System.out.println("Total cards: " + deck.getCards().size());
		
		

		
	}
}
