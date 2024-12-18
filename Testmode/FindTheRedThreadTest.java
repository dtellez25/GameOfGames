import java.util.*;

public class FindTheRedThreadTest {

    public static void main(String[] args) {
        FindTheRedThreadTest game = new FindTheRedThreadTest();
        game.startGame();
    }

    int redThreadKey = 0;

    public void startGame() {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int totalThreads = getTotalThreads(scanner);
        Map<Integer, String> threads = generateThreads(totalThreads, random);
        int spoolsPerTurn = getSpoolsPerTurn(scanner, totalThreads);
        boolean isPlayerTurn = decideFirstTurn(scanner);

        System.out.println("Welcome to the Find the Red Thread game: Player vs Computer!");

        //
        System.out.println("[Testing] the red thread is at key: "+ redThreadKey);

        boolean redFound = false;

        while (!redFound && !threads.isEmpty()) {
            if (isPlayerTurn) {
                redFound = playerTurn(scanner, threads, spoolsPerTurn);
            } else {
                redFound = computerTurn(threads, random, spoolsPerTurn);
            }
            isPlayerTurn = !isPlayerTurn; // Alternate turns
        }

        if (!redFound && threads.isEmpty()) {
            System.out.println("The game is over! No one found the red thread.");
        }

        //scanner.close();
    }

    private int getTotalThreads(Scanner scanner) {
        int totalThreads;
        while (true) {
            System.out.print("Enter the number of threads to play with (2 to 100): ");
            try {
                totalThreads = Integer.parseInt(scanner.nextLine());
                if (totalThreads >= 2 && totalThreads <= 100) {
                    return totalThreads;
                } else {
                    System.out.println("Invalid input. Please choose a number between 2 and 100.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number.");
            }
        }
    }

    private Map<Integer, String> generateThreads(int totalThreads, Random random) {
        Map<Integer, String> threads = new LinkedHashMap<>();
        redThreadKey = random.nextInt(totalThreads) + 1;
        for (int i = 1; i <= totalThreads; i++) {
            if (i == redThreadKey) {
                threads.put(i, "red");
            } else {
                String[] colors = {"blue", "green", "yellow"};
                threads.put(i, colors[random.nextInt(colors.length)]);
            }
        }
        return threads;
    }

    private int getSpoolsPerTurn(Scanner scanner, int totalThreads) {
        int spoolsPerTurn;
        while (true) {
            System.out.print("Enter the number of threads to pick per turn (1 to " + totalThreads / 2 + "): ");
            try {
                spoolsPerTurn = Integer.parseInt(scanner.nextLine());
                if (spoolsPerTurn >= 1 && spoolsPerTurn <= totalThreads / 2) {
                    return spoolsPerTurn;
                } else {
                    System.out.println("Invalid input. Please choose a valid number of threads.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number.");
            }
        }
    }

    private boolean decideFirstTurn(Scanner scanner) {
        while (true) {
            System.out.print("Do you want to go first? (yes/no): ");
            String choice = scanner.nextLine().toLowerCase();
            if (choice.equals("yes")) {
                return true;
            } else if (choice.equals("no")) {
                return false;
            }
            System.out.println("Invalid input. Please enter 'yes' or 'no'.");
        }
    }

    private boolean playerTurn(Scanner scanner, Map<Integer, String> threads, int spoolsPerTurn) {
        System.out.println("\nYour turn.");
        System.out.println("Available threads: " + threads.keySet());
        Set<Integer> chosenKeys = new HashSet<>();

        for (int i = 0; i < spoolsPerTurn && !threads.isEmpty(); i++) {
            System.out.print("Choose a key: ");
            try {
                int chosenKey = Integer.parseInt(scanner.nextLine());

                if (!threads.containsKey(chosenKey)) {
                    System.out.println("Invalid choice. Please select a valid key.");
                    i--; // Allow re-selection for invalid input
                    continue;
                }

                if (!chosenKeys.add(chosenKey)) {
                    System.out.println("You already chose this key. Please select a different key.");
                    i--; // Allow re-selection for duplicate input
                    continue;
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number.");
                i--; // Allow re-selection for invalid input
            }
        }

        for (int chosenKey : chosenKeys) {
            String chosenThread = threads.remove(chosenKey);
            System.out.println("You picked: " + chosenThread);

            if (chosenThread.equals("red")) {
                System.out.println("Congratulations! You found the red thread and won the game!");
                return true;
            }
        }

        if (threads.size() < spoolsPerTurn) {
            System.out.println("Not enough threads for a valid draw. Game ends in a draw!");
            return true;
        }

        return false;
    }

    private boolean computerTurn(Map<Integer, String> threads, Random random, int spoolsPerTurn) {
        System.out.println("\nComputer's turn.");
        List<Integer> availableKeys = new ArrayList<>(threads.keySet());

        for (int i = 0; i < spoolsPerTurn && !availableKeys.isEmpty(); i++) {
            int chosenKey = availableKeys.remove(random.nextInt(availableKeys.size()));
            System.out.println("Computer chose key: " + chosenKey);

            String chosenThread = threads.remove(chosenKey);
            System.out.println("Computer picked: " + chosenThread);

            if (chosenThread.equals("red")) {
                System.out.println("The computer found the red thread. You lose!");
                return true;
            }
        }

        if (threads.size() < spoolsPerTurn) {
            System.out.println("Not enough threads for a valid draw. Game ends in a draw!");
            return true;
        }

        return false;
    }
}
