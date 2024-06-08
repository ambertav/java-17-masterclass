import java.util.ArrayList;

public class Store {

    private static ArrayList<ProductForSale> products = new ArrayList<>();
    private static ArrayList<OrderItem> order = new ArrayList<>();

    public static void main (String[] args) {
        
    }

    public static void listProducts () {
        for (ProductForSale product : products) {
            System.out.print("-".repeat(50));
            product.showDetails();
            System.out.print("-".repeat(50));
        }
    }

    public static void addItemToOrder (ArrayList<OrderItem> order, int index, int quantity) {
        order.add(new OrderItem(quantity, products.get(index)));
    }

    public static void printOrder (ArrayList<OrderItem> order) {
        double salesTotal = 0;

        for (OrderItem item : order) {
            item.getProduct().printPricedLineItem(item.getQuantity());
            salesTotal += item.getProduct().getSalesPrice(item.getQuantity());
        }

        System.out.printf("Sales Total: $%6.2f %n", salesTotal);
    }
}
