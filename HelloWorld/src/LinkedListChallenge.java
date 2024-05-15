import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

/**
 * A program that manages a list of places to visit, allowing navigation forward
 * and backward in the list.
 */
public class LinkedListChallenge {

    /**
     * The main method, where the program starts execution.
     *
     * @param args The command-line arguments (not used).
     */
    public static void main(String[] args) {
        LinkedList<Place> placesToVisit = new LinkedList<>();

        addPlace(placesToVisit, new Place("Flushing", 10));
        addPlace(placesToVisit, new Place("Paradox Lake", 250));
        addPlace(placesToVisit, new Place("Sams Point", 125));
        addPlace(placesToVisit, new Place("Woodstock", 150));

        run(placesToVisit);

    }

    /**
     * Adds a place to the list if it's not already present and maintains the list
     * in ascending order of distance.
     *
     * @param list  The list of places.
     * @param place The place to be added.
     */
    public static void addPlace(LinkedList<Place> list, Place place) {
        for (Place p : list) {
            if (p.getName().equalsIgnoreCase(place.getName()))
                return;
        }

        ListIterator<Place> iterator = list.listIterator();

        while (iterator.hasNext()) {
            Place current = iterator.next();
            if (place.getDistance() < current.getDistance()) {
                iterator.previous();
                iterator.add(place);
                return;
            }
        }
        list.add(place);
    }

    /**
     * Runs the main functionality of navigating through the list of places.
     *
     * @param list The list of places to visit.
     */
    public static void run(LinkedList<Place> list) {
        Scanner scanner = new Scanner(System.in);

        try {

            ListIterator<Place> iterator = list.listIterator();

            boolean flag = true;
            boolean isForward = true;

            printMenu();

            while (flag) {
                if (!iterator.hasPrevious()) {
                    System.out.println("Starting at : " + iterator.next());
                    isForward = true;
                }

                if (!iterator.hasNext()) {
                    System.out.println("Ending at : " + iterator.previous());
                    isForward = false;
                }

                System.out.println("Enter option: ");
                String selectedOption = scanner.nextLine().toLowerCase().substring(0, 1);

                switch (selectedOption) {
                    case "f" -> {
                        System.out.println("Going forward...");
                        if (!isForward) {
                            isForward = true;
                            if (iterator.hasNext())
                                iterator.next();
                        }

                        if (iterator.hasNext())
                            System.out.println(iterator.next());
                        break;
                    }
                    case "b" -> {
                        System.out.println("Going backward...");
                        if (isForward) {
                            isForward = false;
                            if (iterator.hasPrevious())
                                iterator.previous();
                        }

                        if (iterator.hasPrevious())
                            System.out.println(iterator.previous());
                        break;
                    }
                    case "l" -> {
                        System.out.println("Printing itinerary...");
                        System.out.println(list);
                    }
                    case "m" -> printMenu();
                    case "q" -> flag = false;
                    default -> System.out.println("Invalid option, please try again");
                }
            }
        } finally {
            scanner.close();
        }
    }

    /**
     * Prints the menu of available actions.
     */
    private static void printMenu() {
        System.out.println("""
                Available actions (select word or letter) :
                (F)orward
                (B)ackwords
                (L)ist Places
                (M)enu
                (Q)uit
                """);
    }

    /**
     * Represents a place with a name and a distance.
     */
    public static class Place {
        private String name;
        private int distance;

        /**
         * Constructs a place with the given name and distance.
         *
         * @param name     The name of the place.
         * @param distance The distance to the place.
         */
        public Place(String name, int distance) {
            this.name = name;
            this.distance = distance;
        }

        /**
         * Gets the name of the place.
         *
         * @return The name of the place.
         */
        public String getName() {
            return this.name;
        }

        /**
         * Gets the distance to the place.
         *
         * @return The distance to the place.
         */
        public int getDistance() {
            return this.distance;
        }

        /**
         * Returns a string representation of the place.
         *
         * @return A string representation of the place.
         */
        @Override
        public String toString() {
            return String.format("%s : %d miles", this.name, this.distance);
        }
    }
}
