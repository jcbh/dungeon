package game;

import java.util.List;
import java.util.Scanner;

import deck.Card;
import deck.Deck;
import deck.Suit;

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
			playerStatus.setAddWeaponOnThisRound(false);
			playerStatus.setHealthPotionOnThisRound(false);
			
			System.out.println("");
			System.out.println(deck.getCards().size() + " cards remaining in the deck.");
			
			System.out.println("You are in the room number " + (playerStatus.getActualRound()));
			
			List<Card> drawCards = deck.drawCards(4);
			
			while (drawCards.size() > 1 && running) {	
				System.out.println("In that stance you can see: " + drawCards);
				if (playerStatus.getWeaponPower() > 0){
					System.out.println("Your weapon power is " + playerStatus.getWeaponPower());
				}
				System.out.println("You have " + playerStatus.getHealth()+ " health points");
				
				if (drawCards.size() == 4) {
					running = optionsForFourCards(scanner, running, drawCards);
				} else if (drawCards.size() == 3) {
					running = optionsForThreeCards(scanner, running, drawCards);
				} else if (drawCards.size() == 2) {
					running = optionsForTwoCards(scanner, running, drawCards);
				} else if (drawCards.size() == 1 || drawCards.size() == 0) {
					//next room
					System.out.println("Go to the next room");
				} 
				
				if (deck.getCards().size() == 0) {
					System.out.println("No more cards in the deck. You win!");
					//TODO check drawCard to check points
					running = false;					
				}
			
			}
		}
	}

	private boolean optionsForFourCards(Scanner scanner, boolean running, List<Card> drawCards) {
	    System.out.println("\nWhat do you want to do?");
	    System.out.println("1) Choose card number 1: "+drawCards.get(0));
	    System.out.println("2) Choose card number 2: "+drawCards.get(1));
	    System.out.println("3) Choose card number 3: "+drawCards.get(2));
	    System.out.println("4) Choose card number 4: "+drawCards.get(3));
	    System.out.println("5) Scape to the next room");
	    System.out.println("6) Exit");

	    System.out.print("Choose an option: ");
	    String input = scanner.nextLine();

	    switch (input) {
	        case "1":
	        case "2":
	        case "3":
	        case "4":
	            int index = Integer.parseInt(input) - 1;
	            running = cardSelection(index, drawCards, scanner, running);
	            break;
	        case "5":
	            System.out.println("Scape to the next room");
	            running = escapeToNextRoom(drawCards);
	            break;
	        case "6":
	            running = false;
	            break;
	        default:
	            System.out.println("Invalid option. Try again.");
	    }

	    return running;
	}
	
	/*
	 * Steps:
	 * 	a) keep four cards in hand
	 *  b) suffle then
	 *  c) add to the end of the deck
	 *  d) goto next room
	 */
	private boolean escapeToNextRoom(List<Card> drawCards) {
		if (playerStatus.getScapes().contains(playerStatus.getActualRound()-1)) {
			System.out.println("You have scaped the previous room. You can't scape again.");
			return true;
		}
		List<Card> drawCardsClone = new java.util.ArrayList<Card>(drawCards);
		java.util.Collections.shuffle(drawCardsClone);
		deck.getCards().addAll(drawCardsClone);
		drawCards.clear();
		playerStatus.getScapes().add(playerStatus.getActualRound());
		return true;
	}

	private boolean optionsForThreeCards(Scanner scanner, boolean running, List<Card> drawCards) {
	    System.out.println("\nWhat do you want to do?");
	    System.out.println("1) Choose card number 1: "+drawCards.get(0));
	    System.out.println("2) Choose card number 2: "+drawCards.get(1));
	    System.out.println("3) Choose card number 3: "+drawCards.get(2));
	    System.out.println("4) Exit");

	    System.out.print("Choose an option: ");
	    String input = scanner.nextLine();

	    switch (input) {
	        case "1":
	        case "2":
	        case "3":
	            int index = Integer.parseInt(input) - 1;
	            running = cardSelection(index, drawCards, scanner, running);
	            break;
	        case "4":
	            running = false;
	            break;
	        default:
	            System.out.println("Invalid option. Try again.");
	    }

	    return running;
	}
	
	private boolean optionsForTwoCards(Scanner scanner, boolean running, List<Card> drawCards) {
	    System.out.println("\nWhat do you want to do?");
	    System.out.println("1) Choose card number 1: "+drawCards.get(0));
	    System.out.println("2) Choose card number 2: "+drawCards.get(1));
	    System.out.println("3) Exit");

	    System.out.print("Choose an option: ");
	    String input = scanner.nextLine();

	    switch (input) {
	        case "1":
	        case "2":
	            int index = Integer.parseInt(input) - 1;
	            running = cardSelection(index, drawCards, scanner, running);
	            break;
	        case "3":
	            running = false;
	            break;
	        default:
	            System.out.println("Invalid option. Try again.");
	    }

	    return running;
	}

	private boolean cardSelection(int index, List<Card> drawCards, Scanner scanner, boolean running) {
	    System.out.println("Choose card number " + (index + 1));
	    int cardReadedStatus = readCard(drawCards.get(index), scanner);
	    drawCards.remove(index);

	    return cardReadedStatus == 2 ? false : running;
	}


	
	//Quiero controlar el estado del juego con un entero que devuelva esta funcion
	// 1 -> monstruo derrotado
	// 2 -> jugador derrotado
	
	private int readCard(Card card, Scanner scanner) {
		if (card.getSuit().equals(Suit.SPADES.toString()) || card.getSuit().equals(Suit.CLUBS.toString())) {
			// It's a monster
			//Now you must choose if you want to use weapon or health points to fight
			
			int initialMonsterLife = card.getValue();
			int actualMonsterLife = card.getValue();
			
			System.out.println("It's a monster of level "+initialMonsterLife+". Prepare to fight!");
			
			boolean canUseWeapon = false;
			if (playerStatus.getWeaponStatus().size() == 1) {
				canUseWeapon=true;
			}else {
				canUseWeapon = playerStatus.getWeaponStatus().getLast().getValue() >= initialMonsterLife;
			}	
			
			if (playerStatus.getWeaponPower() == 0 ) {
				System.out.println("You only can use your hands (lose health points) to fight");
				actualMonsterLife = combatWithHands(initialMonsterLife);
			} else if (canUseWeapon == false) {
				System.out.println("Your weapon can't attack this monster. You only can use your hands (lose health points) to fight");
				actualMonsterLife = combatWithHands(initialMonsterLife);
			}else {
				System.out.println("1) You can use your hands (lose health points) to fight");
				System.out.println("2) You can use your weapon power ("+playerStatus.getWeaponPower()+") to fight");
				
				System.out.print("Choose an option: ");			
				String input = scanner.nextLine();

				switch (input) {
					case "1":
						System.out.println("Use your hands to fight");
					actualMonsterLife = combatWithHands(initialMonsterLife);
						break;
					case "2":
						System.out.println("Use weapon to fight");
						actualMonsterLife = initialMonsterLife - playerStatus.getWeaponPower();
						playerStatus.getWeaponStatus().add(card);
						break;					
				}
			}			
			
			System.out.println("The monster has "+actualMonsterLife+" life points left.");
			System.out.println("You have "+playerStatus.getHealth()+" health points left.");
			//Check if monster is defeated
			//Check if player is alive
			
			if (playerStatus.getHealth() <= 0) {
				System.out.println("You have been defeated by the monster. Game over.");
				return 2;
			} else if (actualMonsterLife <= 0) {
				System.out.println("The monster has been defeated!");				
				return 1;
			} 
		} else if (card.getSuit().equals(Suit.DIAMONDS.toString())) {
			// It's a weapon
			if (playerStatus.isAddWeaponOnThisRound()==false) {
				int weaponPower = card.getValue();
				playerStatus.setWeaponPower(weaponPower);
				playerStatus.setWeaponStatus(new java.util.ArrayList<Card>());
				playerStatus.getWeaponStatus().add(card);
				playerStatus.setAddWeaponOnThisRound(true);
			} else {
				System.out.println("You have already added a weapon this round. You can't add another one.");
			}			
			return 1;
			
		} else if (card.getSuit().equals(Suit.HEARTS.toString())) {
			// It's a health potion
			if (playerStatus.isHealthPotionOnThisRound()==false) {			
				int healthPoints = card.getValue();
				playerStatus.setHealth(playerStatus.getHealth() + healthPoints);
				playerStatus.setHealthPotionOnThisRound(true);
				System.out.println("It's a health potion! You gain " + healthPoints + " health points.");
			} else {
				System.out.println("You have already used a health potion this round. You can't use another one.");
			}
			return 1;
		}
		return 1;
	}

	private int combatWithHands(int initialMonsterLife) {
		int actualMonsterLife;
		actualMonsterLife = initialMonsterLife - playerStatus.getHealth();
		playerStatus.setHealth(playerStatus.getHealth()-initialMonsterLife);
		
		if (actualMonsterLife < 0) {
			actualMonsterLife = 0;
		}
		
		return actualMonsterLife;
	}
}
