import java.util.Scanner;

public class GameOfGames {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean exitGame = false;

        while (!exitGame) {
            displayMainMenu();
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    findTheThimble();
                    break;
                case 2:
                    coinFlip();
                    break;
                case 3:
                    evenOrOdd();
                    break;
                case 4:
                    findTheRedThread();
                    break;
                case 5:
                    guessTheNumber();
                    break;
                case 6:
                    exitGame = true;
                    displayFinalScoreboard();
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        scanner.close();
    }

    static void displayMainMenu() {
        System.out.println("\nWelcome to Game of Games!");
        System.out.println("1. Find the Thimble");
        System.out.println("2. Coin Flip");
        System.out.println("3. Even or Odd");
        System.out.println("4. Find the Red Thread");
        System.out.println("5. Guess the Number");
        System.out.println("6. Exit Game of Games");
        System.out.print("Choose an option: ");
    }

    static void findTheThimble() {
        System.out.println("Playing Find the Thimble...");
        // Game logic here
    }

    static void coinFlip() {
        System.out.println("Playing Coin Flip...");
        // Game logic here
    }

    static void evenOrOdd() {
        System.out.println("Playing Even or Odd...");
        // Game logic here
    }

    static void findTheRedThread() {
        System.out.println("Playing Find the Red Thread...");
        // Game logic here
    }

    static void guessTheNumber() {
        System.out.println("Playing Guess the Number...");
        // Game logic here
    }

    static void displayFinalScoreboard() {
        System.out.println("Displaying Final Scoreboard...");
        // Scoreboard logic here
    }
}

// Test Class
class GameOfGamesTest {
    public static void main(String[] args) {
        testSunnyDayPaths();
        testRainyDayPaths();
    }

    public static void testSunnyDayPaths() {
        System.out.println("\nRunning Sunny Day Path Tests...");

        System.out.println("1. Test: User selects Find the Thimble...");
        GameOfGames.findTheThimble();

        System.out.println("2. Test: User selects Coin Flip...");
        GameOfGames.coinFlip();

        System.out.println("3. Test: User selects Even or Odd...");
        GameOfGames.evenOrOdd();

        System.out.println("4. Test: User selects Find the Red Thread...");
        GameOfGames.findTheRedThread();

        System.out.println("5. Test: User selects Guess the Number...");
        GameOfGames.guessTheNumber();

        System.out.println("6. Test: User exits a game...");
        GameOfGames.displayMainMenu();

        System.out.println("7. Test: User selects Exit Game of Games...");
        GameOfGames.displayFinalScoreboard();
    }

    public static void testRainyDayPaths() {
        System.out.println("\nRunning Rainy Day Path Tests...");

        System.out.println("1. Test: Computer fails to load game...");
        try {
            GameOfGames.findTheThimble();
        } catch (Exception e) {
            System.out.println("Error encountered. Recovering...");
            GameOfGames.findTheThimble();
        }

        System.out.println("2. Test: Computer fails to show main menu after exiting game...");
        try {
            GameOfGames.displayMainMenu();
        } catch (Exception e) {
            System.out.println("Error encountered. Recovering...");
            GameOfGames.displayMainMenu();
        }

        System.out.println("3. Test: Computer does not update scoreboard on exit...");
        try {
            GameOfGames.displayFinalScoreboard();
        } catch (Exception e) {
            System.out.println("Error encountered. Recovering...");
            GameOfGames.displayFinalScoreboard();
        }
    }
}
