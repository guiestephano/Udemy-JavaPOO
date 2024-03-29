package application;

import entities.Product;

import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        String name;
        double price;
        int quantity;

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter product data:");
        System.out.print("Name: ");
        name = sc.next();
        System.out.print("Price: ");
        price = sc.nextDouble();
        System.out.print("Quantity: ");
        quantity = sc.nextInt();

        Product product = new Product(name, price, quantity);

        System.out.println("\nProduct data: " + product + "\n");

        System.out.print("Enter the number of products to be added in stock: ");
        quantity = sc.nextInt();
        product.addProducts(quantity);
        System.out.println("\nUpdated data: "+ product + "\n");

        System.out.print("Enter the number of products to be removed from stock: ");
        quantity = sc.nextInt();
        product.removeProducts(quantity);
        System.out.println("\nUpdated data: "+ product + "\n");

        sc.close();
    }
}
