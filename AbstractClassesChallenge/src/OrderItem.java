public class OrderItem {
    private int quantity;
    private ProductForSale product;

    public OrderItem (int quantity, ProductForSale product) {
        this.quantity = quantity;
        this.product = product;
    }

    public int getQuantity () {
        return this.quantity;
    }

    public ProductForSale getProduct () {
        return this.product;
    }
}
