import java.util.Random;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class FindTheThimble {

    private static final Scanner scanner = new Scanner(System.in);
    private static volatile boolean timedOut = false;
    private static volatile boolean inputComplete = false;
    private static volatile boolean gameOver = false; 
    private static volatile Boolean roundResult = null; // Stores the result of the round

    public static void main(String[] args) {
        System.out.println("Welcome to 'Find the Thimble'!");
        int bestOutOf = getValidBestOutOf();
        int requiredWins = (bestOutOf / 2) + 1;

        int userScore = 0;
        int computerScore = 0;

        while (userScore < requiredWins && computerScore < requiredWins) {
            System.out.println("\nCurrent Scores - You: " + userScore + ", Computer: " + computerScore);
            resetRoundFlags(); // Reset round flags

            playRound();

            // Update scores based on the final state of roundResult
            synchronized (FindTheThimble.class) {
                if (timedOut && !inputComplete) {
                    System.out.println("Computer gets a point due to timeout.");
                    computerScore++;
                } else if (Boolean.TRUE.equals(roundResult)) {
                    System.out.println("You get a point!");
                    userScore++;
                } else if (Boolean.FALSE.equals(roundResult)) {
                    System.out.println("Computer gets a point!");
                    computerScore++;
                }
            }
        }

        gameOver = true; // End the game
        displayFinalResult(userScore, computerScore);
    }

    private static int getValidBestOutOf() {
        while (true) {
            try {
                System.out.print("Enter 'best out of' number (odd number): ");
                int rounds = Integer.parseInt(scanner.nextLine());
                if (rounds > 0 && rounds % 2 == 1) {
                    return rounds; // Return valid input
                } else {
                    System.out.println("Invalid input. Please enter an odd number greater than 0.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid integer.");
            }
        }
    }

    private static void playRound() {
        Random random = new Random();
        String thimbleHand = random.nextBoolean() ? "left" : "right"; // Randomly choose the thimble's hand

        Thread inputThread = new Thread(() -> {
            try {
                while (!timedOut && !inputComplete) {
                    if (gameOver) return; // Stop thread if the game is over

                    System.out.print("Guess which hand (left or right): ");
                    if (scanner.hasNextLine()) {
                        String guess = scanner.nextLine().trim().toLowerCase();
                        if (timedOut || gameOver) {
                            return; // Stop processing if timeout occurred or game is over
                        }
                        synchronized (FindTheThimble.class) {
                            if (guess.equals("left") || guess.equals("right")) {
                                inputComplete = true; // Mark input as complete
                                processGuess(guess, thimbleHand);
                            } else {
                                System.out.println("Invalid guess. Please enter either 'left' or 'right'.");
                            }
                        }
                    }
                }
            } catch (Exception e) {
            }
        });

        inputThread.start();

        // Timer to handle timeout logic
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                synchronized (FindTheThimble.class) {
                    if (!gameOver && !inputComplete) {
                        timedOut = true; 
                        System.out.println("\nTime's up! You didn't make a guess.");
                    }
                }
            }
        }, 60000); // Set timeout to 60 seconds

        // Wait until the round ends
        while (!timedOut && !inputComplete) {
            if (gameOver) break; // Stop waiting if the game is over
        }

        timer.cancel();
        inputThread.interrupt(); // Interrupt the input thread if timeout occurred or valid input was received
    }

    private static void processGuess(String guess, String thimbleHand) {
        synchronized (FindTheThimble.class) {
            if (gameOver) {
                return; // Do not process guesses if the game is over
            }
            if (guess.equals(thimbleHand)) {
                System.out.println("\nCorrect guess!");
                roundResult = true; // User guessed correctly
            } else {
                System.out.println("\nWrong guess. The thimble was in the " + thimbleHand + " hand.");
                roundResult = false; // User guessed incorrectly
            }
        }
    }

    private static void resetRoundFlags() {
        synchronized (FindTheThimble.class) {
            timedOut = false;
            inputComplete = false;
            roundResult = null;
        }
    }

    private static void displayFinalResult(int userScore, int computerScore) {
        System.out.println("\nGame Over!");
        if (userScore > computerScore) {
            System.out.println("Congratulations! You won!");
        } else {
            System.out.println("Computer wins! Better luck next time.");
        }
        System.out.println("Final Scores - You: " + userScore + ", Computer: " + computerScore);
    }
}
