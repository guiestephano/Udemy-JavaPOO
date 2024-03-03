package entities;

public class OrderItem {
    private Integer quantity;
    private Double price;
    private Product product;

    public OrderItem(Integer quantity, Product product){
        this.quantity = quantity;
        this.product = product;
        price = product.getPrice();
    }
    public Integer getQuantity() {
        return quantity;
    }

    public Double getPrice() {
        return price;
    }
    public Product getProduct(){
        return product;
    }

    public double subTotal(){
        return price * quantity;
    }


}
