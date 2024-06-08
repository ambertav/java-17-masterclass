public class Pastry extends ProductForSale {

    public Pastry (String type, double price, String description) {
        super(type, price, description);
    }

    public void showDetails () {
        System.out.printf("This %s is absolutely delicious %n", type);
        System.out.printf("The price is %8.2f %n", price);
        System.out.println(description);
    }
    
}
