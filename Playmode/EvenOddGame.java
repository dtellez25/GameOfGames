import java.util.Scanner;
import java.util.Random;

public class EvenOddGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int bestOf = getBestOf(scanner);
        int winningPoints = (bestOf / 2) + 1;
        int userPoints = 0;
        int computerPoints = 0;

        while (userPoints < winningPoints && computerPoints < winningPoints) {
            String userChoice = getUserChoice(scanner);
            int userNumber = getUserNumber(scanner);
            int computerNumber = getComputerNumber(random);

            System.out.println("Computer chose: " + computerNumber);

            int sum = userNumber + computerNumber;
            System.out.println("Sum: " + sum);

            String result = determineEvenOrOdd(sum);
            System.out.println("The sum is " + result + ".");

            if (userChoice.equals(result)) {
                System.out.println("You win this round!");
                userPoints++;
            } else {
                System.out.println("Computer wins this round!");
                computerPoints++;
            }

            displayScore(userPoints, computerPoints);
        }

        declareWinner(userPoints, winningPoints);
        //scanner.close();
    }

    private static int getBestOf(Scanner scanner) {
        int bestOf;
        while (true) {
            System.out.print("Enter an odd 'best out of' number: ");
            bestOf = scanner.nextInt();
            if (bestOf > 0 && bestOf % 2 != 0) {
                return bestOf;
            } else {
                System.out.println("Invalid input. Please enter a positive odd number.");
            }
        }
    }

    private static String getUserChoice(Scanner scanner) {
        while (true) {
            System.out.print("Choose 'odd' or 'even': ");
            String userChoice = scanner.next().toLowerCase();
            if (userChoice.equals("odd") || userChoice.equals("even")) {
                return userChoice;
            } else {
                System.out.println("Invalid choice. Please choose 'odd' or 'even'.");
            }
        }
    }

    private static int getUserNumber(Scanner scanner) {
        while (true) {
            System.out.print("Enter a positive number: ");
            int userNumber = scanner.nextInt();
            if (userNumber > 0) {
                return userNumber;
            } else {
                System.out.println("Invalid number. Please enter a positive number.");
            }
        }
    }

    private static int getComputerNumber(Random random) {
        return random.nextInt(10) + 1; // Random number between 1 and 10
    }

    private static String determineEvenOrOdd(int sum) {
        if (sum % 2 == 0) { 
            return "even";
        } else {
            return "odd";
        }
    }

    private static void displayScore(int userPoints, int computerPoints) {
        System.out.println("Score: You " + userPoints + " - Computer " + computerPoints);
    }

    private static void declareWinner(int userPoints, int winningPoints) {
        if (userPoints == winningPoints) {
            System.out.println("Congratulations! You won the game!");
        } else {
            System.out.println("Computer wins the game. Better luck next time!");
        }
    }
}
