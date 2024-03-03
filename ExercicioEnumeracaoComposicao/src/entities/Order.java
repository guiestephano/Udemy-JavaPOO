package entities;

import entities.enums.OrderStatus;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Order {
    private LocalDateTime dateTime;
    private DateTimeFormatter format1 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
    private DateTimeFormatter format2 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private OrderStatus status;

    private Client client;
    private List<OrderItem> items = new ArrayList<>();

    public Order(OrderStatus status, Client client){
        dateTime = LocalDateTime.now();
        this.status = status;
        this.client = client;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public Client getClient() {
        return client;
    }

    public List<OrderItem> getItems() {
        return items;
    }

    public void addItem(OrderItem item){
        items.add(item);
    }

    public void removeItem(OrderItem item){
        items.remove(item);
    }

    public double total(){
        double total = 0;
        for (OrderItem item : items){
            total += item.subTotal();
        }
        return total;
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Order moment: " + format1.format(dateTime) + "\n");
        sb.append("Order status: " + status  + "\n");
        sb.append("Client: " + client.getName() + " (" + format2.format(client.getBirthDate()) + ") - " + client.getEmail() + "\n");
        sb.append("Order items:" + "\n");
        for (OrderItem item : items){
            sb.append(item.getProduct().getName()+ ", ");
            sb.append("$" + String.format("%.2f", item.getPrice()) + ", ");
            sb.append("Quantity: " + item.getQuantity() + ", ");
            sb.append("Subtotal: $" + String.format("%.2f",item.subTotal()) + "\n");
        }
        sb.append("Total price: $" + String.format("%.2f", total()));
        return sb.toString();
    }
}
