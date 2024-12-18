
import java.util.Scanner;
import java.util.Random;
class Game {
    private final int bestOutOf;
    private final int maxGuesses;
    private int userPoints = 0;
    private int computerPoints = 0;
    private int secretNumber;
    private int rangeMin;
    private int rangeMax;
    private final Scanner scanner = new Scanner(System.in);

    public Game(int bestOutOf) {
        this.bestOutOf = bestOutOf;
        this.maxGuesses = 5;
    }

    public void start() {
        while (userPoints < bestOutOf && computerPoints < bestOutOf) {
            initializeRound();
            playRound();
        }
        displayFinalScore();
    }

    private void initializeRound() {
        Random random = new Random();
        rangeMin = random.nextInt(50) + 1; // Random range starting point
        rangeMax = rangeMin + random.nextInt(50) + 10; // Ensure range has at least 10 values
        secretNumber = random.nextInt(rangeMax - rangeMin + 1) + rangeMin;
        // System.out.println(secretNumber);
        System.out.println("New Round: Guess a number between " + rangeMin + " and " + rangeMax);
    }

    private void playRound() {
        int guessesLeft = maxGuesses;

        while (guessesLeft > 0) {
            System.out.println("You have " + guessesLeft + " guesses left. Enter your guess:");
            int userGuess = scanner.nextInt();

            if (userGuess < rangeMin || userGuess > rangeMax) {
                System.out.println("Invalid guess. Please guess within the range " + rangeMin + " to " + rangeMax);
                continue;
            }

            if (userGuess == secretNumber) {
                System.out.println("Correct! You guessed the secret number.");
                userPoints++;
                return;
            } else {
                System.out.println("Wrong guess! The number is " + (userGuess < secretNumber ? "higher." : "lower."));
                guessesLeft--;
            }
        }

        System.out.println("No guesses left! The secret number was: " + secretNumber);
        computerPoints++;
    }

    private void displayFinalScore() {
        System.out.println("GameOfGames.Game Over! Final Score:");
        System.out.println("User Points: " + userPoints);
        System.out.println("Computer Points: " + computerPoints);
        if (userPoints > computerPoints) {
            System.out.println("Congratulations! You won the game.");
        } else {
            System.out.println("Better luck next time. The computer won the game.");
        }
    }
}

public class GuessTheNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int bestOutOf;

        while (true) {
            System.out.println("Enter an odd number for 'best out of':");
            bestOutOf = scanner.nextInt();
            if (bestOutOf > 0 && bestOutOf % 2 != 0) {
                break;
            }
            System.out.println("Invalid input. Please enter a positive odd number.");
        }

        Game game = new Game(bestOutOf);
        game.start();
    }
}


