import java.util.Scanner;

public class PlayGames {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            // Display the main menu
            System.out.println("\nWelcome to the Game of Games!");
            System.out.println("1. Play Coin Flip");
            System.out.println("2. Play Find the Thimble");
            System.out.println("3. Play Even and Odd");
            System.out.println("4. Play Find the Red Thread");
            System.out.println("5. Play Guess the Number");
            System.out.println("6. Exit Game of Games");
            System.out.print("Enter your choice: ");

            if (!scanner.hasNextInt()) { // Validate input is an integer
                System.out.println("Invalid input. Please enter a number.");
                scanner.next(); // Consume the invalid input
                continue;
            }

            int choice = scanner.nextInt(); // Get user's menu choice

            switch (choice) {
                case 1:
                    playCoinFlip(); // Call the Coin Flip game
                    break;
                case 2:
                    playFindTheThimble(); // Call the Find the Thimble game
                    break;
                case 3:
                    playEvenAndOdd(); // Call the Even and Odd game
                    break;
                case 4:
                    playFindTheRedThread(); // Call the Find the Red Thread game
                    break;
                case 5:
                    GuessTheNumber(); // Call the Find Guess the number game
                    break;
                case 6:
                    System.out.println("Exiting Game of Games. Goodbye!");
                    return; // Exit the program
                default:
                    System.out.println("Invalid choice. Please select a valid option.");
            }
        }
    }

    private static void playCoinFlip() {
        System.out.println("\n--- Coin Flip ---");
        int roundsToWin = GetInput.getValidOddNumber();
        CoinFlip game = new CoinFlip(roundsToWin);

        while (!game.isGameOver()) {
            String userGuess = GetInput.getGuess();
            game.playRound(userGuess);
            game.displayScores();
        }

        System.out.println("Coin Flip Game Over! Winner: " + game.getWinner());
    }

    private static void playFindTheThimble() {
        System.out.println("\n--- Find the Thimble ---");
        FindTheThimble.main(null);
    }

    private static void playEvenAndOdd() {
        System.out.println("\n--- Even and Odd ---");
        EvenOddGame.main(null);
    }

    private static void playFindTheRedThread() {
        System.out.println("\n--- Find the Red Thread ---");
        FindTheRedThread.main(null);
    }

    private static void GuessTheNumber() {
        System.out.println("\n--- Guess the Number ---");
        GuessTheNumber.main(null);
    }
}
