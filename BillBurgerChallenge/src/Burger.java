import java.util.Arrays;

/**
 * Represents a burger.
 */
public class Burger {
    private String type;
    private int price;
    private String[] toppings = new String[0];
    private boolean isDeluxe;

    /**
     * Constructs a regular burger with no toppings.
     */
    public Burger() {
        this("regular", new String[0]);
    }

    /**
     * Constructs a burger with the specified type and toppings.
     * If the number of toppings exceeds 5, only the first 5 toppings will be
     * considered.
     * If the number of toppings exceeds 3, the burger is considered deluxe.
     *
     * @param type     the type of the burger
     * @param toppings the toppings of the burger
     */
    public Burger(String type, String[] toppings) {
        this.type = type;

        // restrict max toppings to 5 
        if (this.toppings.length > 5) {
            System.out.println("Maximum of 5 toppings exceeded");
            this.toppings = Arrays.copyOf(toppings, 5);
        } else
            this.toppings = toppings;

        // if toppings greater than 3, burger is deluxe
        if (this.toppings.length > 3)
            this.isDeluxe = true;

        // set price based on deluxe status
        this.price = isDeluxe ? 5 : 3;
    }

    /**
     * Adds a topping to the burger.
     * If adding another topping makes the burger deluxe, the price will be updated
     * accordingly.
     *
     * @param topping the topping to add
     */
    public void addTopping(String topping) {
        // adjust deluxe status and price if toppings are going to be greater than 3
        if (this.toppings.length == 3) {
            System.out.println("Adding another topping makes this burger deluxe. Price will be updated");
            this.isDeluxe = true;
            this.price = isDeluxe ? 5 : 3;
        }

        // return if trying to add more than 5 toppings
        if (this.toppings.length >= 5) {
            System.out.println("Maximum of 5 toppings exceeded");
            return;
        }

        // creating new array with extra slot for new topping
        String[] newToppings = Arrays.copyOf(this.toppings, this.toppings.length + 1);

        // add new topping and set
        newToppings[newToppings.length - 1] = topping;
        this.toppings = newToppings;
    }

    /**
     * Removes a topping from the burger.
     * If the number of toppings becomes 3 after removal, the burger is no longer
     * deluxe and the price is updated accordingly.
     *
     * @param topping the topping to remove
     * @return true if the topping was successfully removed, false otherwise
     */
    public boolean removeTopping(String topping) {

        // finds index of desired topping to remove
        int index = -1;
        for (int i = 0; i < this.toppings.length; i++) {
            if (this.toppings[i].equals(topping)) {
                index = i;
                break;
            }
        }

        if (index >= 0 && index < this.toppings.length) {
            String[] newToppings = new String[this.toppings.length - 1];
            System.arraycopy(this.toppings, 0, newToppings, 0, index);
            System.arraycopy(this.toppings, index + 1, newToppings, index, this.toppings.length - index - 1);
            this.toppings = newToppings;

            // if number of toppings is now 3, set burger to not deluxe
            if (this.toppings.length == 3) {
                this.isDeluxe = false;
                // update price
                this.price = isDeluxe ? 5 : 3;
            }

            return true;
        }

        return false;
    }

    /**
     * Gets the price of the burger.
     *
     * @return the price of the burger
     */
    public int getPrice() {
        return this.price;
    }

    /**
     * Returns a string representation of the burger.
     *
     * @return a string representation of the burger
     */
    @Override
    public String toString() {
        return "Burger{" +
                "type='" + type + '\'' +
                ", price=" + price +
                ", toppings=" + (toppings.length > 0 ? Arrays.toString(toppings) : "none") +
                ", isDeluxe=" + isDeluxe +
                '}';
    }
}
