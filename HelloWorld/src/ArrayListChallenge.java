import java.util.Scanner;
import java.util.ArrayList;

/**
 * A program that allows users to manage a grocery list.
 */
public class ArrayListChallenge {
    private static Scanner scanner = new Scanner(System.in);

    /**
     * Main method to run the program.
     * 
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        ArrayList<String> groceries = new ArrayList<>();

        boolean flag = true;
        try {
            while (flag) {
                int option = printOptions();
                switch (option) {
                    case 1 -> addItems(groceries);
                    case 2 -> removeItems(groceries);
                    case 3 -> System.out.printf("%n%s%n%n", groceries);
                    default -> {
                        System.out.println("Quitting...");
                        flag = false;
                    }
                }
            }
        } finally {
            scanner.close();
        }
    }

    /**
     * Prints the options menu and prompts the user for input.
     * 
     * @return The chosen option.
     */
    private static int printOptions() {
        System.out.printf("""
                Enter:
                  1 to add items
                  2 to remove items
                  3 to print out grocery list
                  0 to quit%n%n""");

        while (true) {
            String input = scanner.nextLine();
            try {
                int number = Integer.parseInt(input);
                if (number >= 0 && number <= 3)
                    return number;
                else
                    System.out.println("Please enter either 0, 1, 2, or 3");
            } catch (NumberFormatException error) {
                System.out.println("Please enter either 0, 1, 2, or 3");
            }
        }
    }

    /**
     * Adds items to the grocery list.
     * 
     * @param groceries The grocery list.
     */
    private static void addItems(ArrayList<String> groceries) {
        System.out.println("Please enter a comma delimited list of grocery items to add: ");
        String[] items = scanner.nextLine().split(",");
        for (String item : items) {
            if (groceries.indexOf(item) < 0)
                groceries.add(item.trim());
        }
    }

    /**
     * Removes items from the grocery list.
     * 
     * @param groceries The grocery list.
     */
    private static void removeItems(ArrayList<String> groceries) {
        System.out.println("Please enter a comma delimited list of grocery items to add: ");
        String[] items = scanner.nextLine().split(",");
        for (String item : items) {
            groceries.remove(item.trim());
        }
    }
}
