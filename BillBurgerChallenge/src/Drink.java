import java.util.Arrays;

/**
 * Represents a drink.
 */
public class Drink {
    private String type;
    private String size;
    private int price;

    /**
     * Constructs a drink with the specified type and size.
     *
     * @param type the type of the drink
     * @param size the size of the drink
     */
    public Drink(String type, String size) {
        this.type = type;

        // validate and set size of drink
        String[] validSizes = { "small", "medium", "large" };
        if (Arrays.asList(validSizes).contains(size))
            this.size = size;
        else
            this.size = "small";

        // set price of drink based on size
        this.price = switch (size) {
            case "medium" -> 2;
            case "large" -> 3;
            default -> 1;
        };
    }

    /**
     * Changes the size of the drink.
     *
     * @param newSize the new size of the drink
     */
    public void changeSize(String newSize) {
        if (this.size == newSize)
            return;
        String[] validSizes = { "small", "medium", "large" };
        if (Arrays.asList(validSizes).contains(newSize))
            this.size = newSize;
        else
            this.size = "small";
        recalculatePrice(newSize);
    }

    /**
     * Recalculates the price of the drink based on its size.
     */
    public void recalculatePrice(String newSize) {
        this.price = switch (size) {
            case "medium" -> 2;
            case "large" -> 3;
            default -> 1;
        };
    }

    /**
     * Gets the price of the drink.
     *
     * @return the price of the drink
     */
    public int getPrice() {
        return this.price;
    }

    /**
     * Returns a string representation of the drink.
     *
     * @return a string representation of the drink
     */
    @Override
    public String toString() {
        return "Drink{" +
                "type='" + type + '\'' +
                ", size='" + size + '\'' +
                ", price=" + price +
                '}';
    }
}
