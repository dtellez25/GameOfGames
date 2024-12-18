import java.util.Scanner;

public class PlayGamesTest {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean exitGame = false;

        while (!exitGame) {
            displayMainMenu();
            int choice;

            // Validate user input
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number between 1 and 6.");
                continue;
            }

            // Handle menu choices
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
                    System.out.println("Invalid choice. Please enter a number between 1 and 6.");
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
        System.out.println("\n--- Find the Thimble ---");
        FindTheThimbleTest.main(null); // Ensure FindTheThimbleTest is properly implemented
    }

    static void coinFlip() {
        System.out.println("\n--- Coin Flip ---");
        CoinFlipTest.main(null); // Ensure CoinFlipTest is properly implemented
    }

    static void evenOrOdd() {
        System.out.println("\n--- Even or Odd ---");
        EvenOddGameTest.main(null); // Ensure EvenOddGameTest is properly implemented
    }

    static void findTheRedThread() {
        System.out.println("\n--- Find the Red Thread ---");
        FindTheRedThreadTest.main(null); // Ensure FindTheRedThreadTest is properly implemented
    }

    static void guessTheNumber() {
        System.out.println("\n--- Guess the Number ---");
        Scanner scanner = new Scanner(System.in);
        int numberToGuess = (int) (Math.random() * 100) + 1; // Random number between 1 and 100
        int attempts = 0;
        boolean guessedCorrectly = false;

        while (!guessedCorrectly) {
            System.out.print("Enter your guess (1-100): ");
            int userGuess;

            // Validate input
            try {
                userGuess = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number.");
                continue;
            }

            attempts++;

            if (userGuess < numberToGuess) {
                System.out.println("Too low! Try again.");
            } else if (userGuess > numberToGuess) {
                System.out.println("Too high! Try again.");
            } else {
                System.out.println("Congratulations! You guessed the number in " + attempts + " attempts.");
                guessedCorrectly = true;
            }
        }
    }

    static void displayFinalScoreboard() {
        System.out.println("Displaying Final Scoreboard...");
        System.out.println("Thank you for playing Game of Games!");
    }
}
