/**
 * Represents a meal consisting of a burger, side, and drink.
 */
public class Meal {
    private Burger burger;
    private Side side;
    private Drink drink;

    /**
     * Constructs a default meal with regular burger, small fries, and small coke.
     */
    public Meal() {
        this("regular", new String[0], "coke", "small", "fries");
    }

    /**
     * Constructs a meal with the specified components.
     *
     * @param burgerType     the type of burger
     * @param burgerToppings the toppings of the burger
     * @param drinkType      the type of drink
     * @param drinkSize      the size of the drink
     * @param sideType       the type of side
     */
    public Meal(String burgerType, String[] burgerToppings, String drinkType, String drinkSize, String sizeType) {
        this.burger = new Burger(burgerType, burgerToppings);
        this.drink = new Drink(drinkType, drinkSize);
        this.side = new Side(sizeType);
    }

    /**
     * Adds a topping to the burger of the meal.
     *
     * @param topping the topping to add
     * @return a string representation of the updated burger
     */
    public String addToppingsToBurger(String topping) {
        this.burger.addTopping(topping);
        return this.burger.toString();
    }

    /**
     * Changes the size of the drink of the meal.
     *
     * @param newSize the new size of the drink
     * @return a string representation of the updated drink
     */
    public String changeDrinkSize(String newSize) {
        this.drink.changeSize(newSize);
        return this.drink.toString();
    }

    /**
     * Removes a topping from the burger of the meal.
     *
     * @param topping the topping to remove
     * @return a string representation of the updated burger if the topping was
     *         successfully removed, "Topping not found" otherwise
     */
    public String removeBurgerTopping(String topping) {
        boolean success = this.burger.removeTopping(topping);
        if (success)
            return this.burger.toString();
        else
            return "Topping not found";
    }

    /**
     * Returns a string representation of the meal.
     *
     * @return a string representation of the meal
     */
    @Override
    public String toString() {
        return "Meal{" +
                "burger=" + burger.toString() +
                ", side=" + side.toString() +
                ", drink=" + drink.toString() +
                '}';
    }

    /**
     * Returns an itemized list of the meal components.
     *
     * @return an itemized list of the meal components
     */
    public String getItemizedList() {
        return this.toString();
    }

    /**
     * Calculates and returns the total price of the meal.
     *
     * @return the total price of the meal
     */
    public int totalPrice() {
        return this.burger.getPrice() + this.drink.getPrice() + this.side.getPrice();
    }
}
