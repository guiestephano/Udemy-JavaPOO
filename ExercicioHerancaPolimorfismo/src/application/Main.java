package application;

import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        List<Product> list = new ArrayList<>();

        System.out.print("Enter the number of products: ");
        int number = sc.nextInt();
        for(int i = 1; i <= number; i++){
            System.out.println("Product #" + i + " data:");
            boolean invalidChoice = false;
            String name;
            Double price;
            do{
                invalidChoice = false;
                System.out.print("Common, used or imported (c/u/i): ");
                char choice = sc.next().toLowerCase().charAt(0);
                if(choice == 'c'){
                    System.out.print("Name: ");
                    sc.nextLine();
                    name = sc.nextLine();
                    System.out.print("Price: ");
                    price = sc.nextDouble();
                    list.add(new Product(name,price));
                } else if (choice == 'u') {
                    System.out.print("Name: ");
                    sc.nextLine();
                    name = sc.nextLine();
                    System.out.print("Price: ");
                    price = sc.nextDouble();
                    System.out.print("Manufacture date (DD/MM/YYYY): ");
                    LocalDate date = LocalDate.parse(sc.next(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                    list.add(new UsedProduct(name, price, date));
                } else if (choice == 'i') {
                    System.out.print("Name: ");
                    sc.nextLine();
                    name = sc.nextLine();
                    System.out.print("Price: ");
                    price = sc.nextDouble();
                    System.out.print("Customs fee: ");
                    Double customsFee = sc.nextDouble();
                    list.add(new ImportedProduct(name,price,customsFee));
                }else{
                    invalidChoice = true;
                    System.out.println("Invalid choice, try again!");
                }
            }while (invalidChoice);
        }

        System.out.println("\nPRICE TAGS:");
        for( Product product : list){
            System.out.println(product.priceTag());
        }
        sc.close();
    }
}
