import java.util.Arrays;

/**
 * Represents a side item.
 */
public class Side {
    private String type;
    private int price;

    /**
     * Constructs a side item with the specified type.
     *
     * @param type the type of the side item
     */
    public Side(String type) {
        // validates and sets type
        String[] validTypes = { "fries", "onion rings", "sweet potato fries" };
        if (Arrays.asList(validTypes).contains(type))
            this.type = type;
        else
            this.type = "fries";

        // sets price based on type
        this.price = switch (type) {
            case "onion rings" -> 2;
            case "sweet potato fries" -> 2;
            default -> 1;
        };
    }

    /**
     * Gets the price of the side item.
     *
     * @return the price of the side item
     */
    public int getPrice() {
        return this.price;
    }

    /**
     * Returns a string representation of the side item.
     *
     * @return a string representation of the side item
     */
    @Override
    public String toString() {
        return "Side{" +
                "type='" + type + '\'' +
                ", price=" + price +
                '}';
    }
}
