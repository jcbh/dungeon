package game;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Dungeon Game!");

        boolean running = true;

        while (running) {
            System.out.println("\nWhat do you want to do?");
            System.out.println("1) Start new game");
            System.out.println("2) Load game");
            System.out.println("3) Exit");

            System.out.print("Choose an option: ");
            String input = scanner.nextLine();

            switch (input) {
                case "1":
                    System.out.println("Starting new game...");
					Game game = new Game();
					game.startNewGame(scanner);
                    break;
                case "2":
                    System.out.println("Loading game...");
                    // Aquí iría la lógica para cargar partida
                    
                    break;
                case "3":
                    System.out.println("Exiting. Goodbye!");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid option. Try again.");
            }
        }

        scanner.close();
    }
}
