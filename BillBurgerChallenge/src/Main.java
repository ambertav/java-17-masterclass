public class Main {

    public static void main (String[] args) {
        Meal meal = new Meal();


       System.out.println(meal.getItemizedList());
       System.out.println(meal.totalPrice());

        // meal.addToppingsToBurger("tomato");
        // meal.addToppingsToBurger("lettuce");
        // meal.addToppingsToBurger("cheese");
        // meal.addToppingsToBurger("pickles");
        // System.out.println(meal.getItemizedList());
        // meal.removeBurgerTopping("pickles");
        // System.out.println(meal.getItemizedList());


        Meal secondMeal = new Meal("double", new String[]{"swiss cheese"}, "coke", "medium", "onion rings");

        System.out.println(secondMeal.getItemizedList());
        System.out.println(secondMeal.totalPrice());
    }
}
