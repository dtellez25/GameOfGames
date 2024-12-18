/**
 * Group: Benedicte, Dago, Joachim & Myrian
 * Assigned member: Myri Ayala
 * CoinFlipTest Class
 * Description: Test for CoinFlip
 */

public class CoinFlipTest {
    private int roundsToWin;
    private int userScore;
    private int computerScore;

    // Constructor to initialize the game with the required number of rounds to win
    public CoinFlipTest(int roundsToWin) {
        this.roundsToWin = roundsToWin;
        this.userScore = 0;
        this.computerScore = 0;
    }

    // Method to simulate a single round of the game
    public void playRound(String userGuess) {
        // Simulate a coin flip ("Heads" or "Tails")
        String coinFlipResult = Math.random() < 0.5 ? "Heads" : "Tails";

        System.out.println("Coin flip result: " + coinFlipResult);

        // Check if the user's guess matches the coin flip result
        if (userGuess.equalsIgnoreCase(coinFlipResult)) {
            System.out.println("User wins this round!");
            userScore++;
        } else {
            System.out.println("Computer wins this round!");
            computerScore++;
        }
    }

    // Method to check if the game is over
    public boolean isGameOver() {
        return userScore == roundsToWin || computerScore == roundsToWin;
    }

    // Method to display the current scores
    public void displayScores() {
        System.out.println("User Score: " + userScore + ", Computer Score: " + computerScore);
    }

    // Method to determine the winner
    public String getWinner() {
        if (userScore == roundsToWin) {
            return "User";
        } else if (computerScore == roundsToWin) {
            return "Computer";
        } else {
            return "No winner yet!";
        }
    }

    // Main method to test the CoinFlipTest class
    public static void main(String[] args) {
        // Create a new CoinFlip game with 3 rounds to win
        CoinFlipTest game = new CoinFlipTest(3);

        // Simulate the game rounds
        System.out.println("Starting the Coin Flip game...");

        // Play rounds until the game is over
        while (!game.isGameOver()) {
            // Simulate a user guess (e.g., "Heads")
            String userGuess = "Heads";

            // Play a round and display results
            System.out.println("User guesses: " + userGuess);
            game.playRound(userGuess);
            game.displayScores();
        }

        // Display the final winner
        System.out.println("Game Over!");
        System.out.println("The winner is: " + game.getWinner());
    }
}