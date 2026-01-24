package game;

import java.util.List;
import java.util.Scanner;

import deck.Card;
import deck.Deck;

public class Game {

	private PlayerStatus playerStatus;
	private Deck deck;

	public Game() {
		deck = new Deck();
		deck = deck.generateDungeonDeck();
		deck.shuffle();

		playerStatus = new PlayerStatus();
	}

	public void startNewGame(Scanner scanner) {

		boolean running = true;

		while (running) {
			
			playerStatus.setActualRound(playerStatus.getActualRound() + 1);
			
			System.out.println("You are in the room number " + (playerStatus.getActualRound()));
			System.out.println("You have " + playerStatus.getHealth()+ " health points");
			
			List<Card> drawCards = deck.drawCards(4);
			
			System.out.println("In that stance you can see: " + drawCards);
			
			System.out.println("\nWhat do you want to do?");
			System.out.println("1) Choose card number 1");
			System.out.println("2) Choose card number 2");
			System.out.println("3) Choose card number 3");
			System.out.println("4) Choose card number 4");
			System.out.println("5) Scape to the next room");
			System.out.println("6) Exit");

			System.out.print("Choose an option: ");			
			String input = scanner.nextLine();

			switch (input) {
			case "1":
				System.out.println("Choose card number 1");
				break;
			case "2":
				System.out.println("Choose card number 2");
				break;
			case "3":
				System.out.println("Choose card number 3");
				break;
			case "4":
				System.out.println("Choose card number 5");
				break;
			case "5":
				System.out.println("Scape to the next room");
				break;
			case "6":
				running = false;
				break;
			default:
				System.out.println("Invalid option. Try again.");
			}
		}
	}
}
