/**
 * Group: Benedicte, Dago, Joachim & Myrian
 * Assigned member: Myri Ayala
 * CoinFlip Class
 * Description: Represents the Coin Flip game logic.
 */


import java.util.Random;


public class CoinFlip {
    private int userScore = 0; // Tracks the user's score
    private int computerScore = 0; // Tracks the computer's score
    private int roundsToWin; // Minimum rounds required to win the game
    private Random random = new Random(); // Random object for coin flipping

    /**
     * Constructor to initialize the CoinFlip game.
     *
     * @param roundsToWin The number of rounds required to win the game.
     */
    public CoinFlip(int roundsToWin) {
        this.roundsToWin = roundsToWin; // To set the winning condition
    }
    /**
     * Method 'flipCoin' : simulates  "coin flip"
     *
     * @return "Heads" or "Tails" randomly.
     */
    public String flipCoin() {
        return random.nextBoolean() ? "Heads" : "Tails"; // Returns the coin flip result
    }
    /**
     * Method  'PlayRound' : Plays one round of the game.
     *
     * @param userGuess The user's guess ("Heads" or "Tails").
     * @return True if the user guessed correctly, false otherwise.
     */
    public boolean playRound(String userGuess) {
        String result = flipCoin(); // Simulate the coin flip
        System.out.println("Coin shows: " + result); // Display the result

        // Check if the user's guess matches the coin flip result
        if (result.equalsIgnoreCase(userGuess)) {
            userScore++; // Increment user score
            System.out.println("You guessed correctly!");
            return true;
        } else {
            computerScore++; // Increment computer score
            System.out.println("Incorrect guess.");
            return false;
        }
    }
    /**
     * Method 'isGameOver' : Checks if the game is over.
     *
     * @return True if either the user or the computer has won, false otherwise.
     */
    public boolean isGameOver() {
        return userScore >= roundsToWin || computerScore >= roundsToWin;
    }
    /**
     * Displays the current scores of both the user and the computer.
     */
    public void displayScores() {
        System.out.println("User Score: " + userScore);
        System.out.println("Computer Score: " + computerScore);
    }

    /**
     * Determines the winner of the game.
     *
     * @return "User" if the user has won, "Computer" otherwise.
     */
    public String getWinner() {
        return userScore > computerScore ? "User" : "Computer"; // Determine the winner
    }
}
