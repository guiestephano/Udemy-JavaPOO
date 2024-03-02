package application;

import entities.CurrencyConverter;

import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){

        double dolarPrice, quantity;

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.print("What is the dollar price? ");
        dolarPrice = sc.nextDouble();
        System.out.print("How many dollar will be bought? ");
        quantity = sc.nextDouble();
        System.out.printf("Amount to be paid in reais = %.2f%n", CurrencyConverter.amount(dolarPrice, quantity));
        sc.close();
    }
}
