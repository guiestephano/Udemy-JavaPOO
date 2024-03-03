package application;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStatus;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter client data:");

        System.out.print("Name: ");
        String name = sc.nextLine();
        System.out.print("Email: ");
        String email = sc.nextLine();
        System.out.print("Birth date (DD/MM/YYYY): ");
        LocalDate localDate= LocalDate.parse(sc.next(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));

        Client client = new Client(name,email, localDate);

        System.out.println("Enter order data:");
        System.out.print("Status: ");
        sc.nextLine();
        OrderStatus status = OrderStatus.valueOf(sc.nextLine().toUpperCase().replace(' ', '_'));

        Order order = new Order(status,client);

        System.out.print("How many items to this order? ");
        int n = sc.nextInt();

        for(int i = 1; i <= n; i++){
            System.out.println("Enter #" + i + " item data:");
            System.out.print("Product name: ");
            sc.nextLine();
            name = sc.nextLine();
            System.out.print("Product price: ");
            double price = sc.nextDouble();

            Product product = new Product(name, price);

            System.out.print("Quantity: ");
            int quantity = sc.nextInt();

            OrderItem item = new OrderItem(quantity, product);
            order.addItem(item);
        }

        System.out.println("\nORDER SUMMARY:");
        System.out.println(order);
        sc.close();
    }
}
