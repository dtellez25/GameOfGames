/**
 * Group: Benedicte, Dago, Joachim & Myrian
 * Assigned member: Myri Ayala
 * GetInput Class
 * Description: Handles all user input for the game, including validation
 */

import java.util.Scanner;

public class GetInput {
    private static Scanner scanner = new Scanner(System.in); // Scanner for user input

    /**
     * Prompts the user to input a valid odd number of rounds to play.
     *
     * @return A positive odd number.
     */
    public static int getValidOddNumber() {
        int number;
        while (true) {
            System.out.print("Enter an odd number of rounds to play: "); // Prompt the user
            number = scanner.nextInt(); // Read input

            // Validate input: positive and odd
            if (number > 0 && number % 2 != 0) {
                break; // Exit loop if input is valid
            }
            System.out.println("Invalid input. Please enter a positive odd number."); // Error message
        }
        return number; // Return the valid input
    }

    /**
     * Prompts the user to guess "Heads" or "Tails".
     *
     * @return The user's guess as a string.
     */
    public static String getGuess() {
        System.out.print("Guess 'Heads' or 'Tails': "); // Prompt the user
        return scanner.next(); // Read and return the input
    }
}
