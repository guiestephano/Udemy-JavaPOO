package application;

import entities.Account;

import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        String holder;
        int number;
        double depositValue, withdrawValue;
        Account account;
        char option;

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter account number: ");
        number = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter account holder: ");
        holder = sc.nextLine();
        System.out.print("Is there a initial deposit value (y/n)? ");
        option = sc.next().charAt(0);

        if(option == 'y' || option == 'Y'){
            System.out.print("Enter initial deposit value: ");
            depositValue = sc.nextDouble();
            account = new Account(number, holder, depositValue);
        }
        else{
            account = new Account(number, holder);
        }

        System.out.println("\nAccount data:");
        System.out.println(account);

        System.out.print("\nEnter a deposit value: ");
        depositValue = sc.nextDouble();
        account.deposit(depositValue);
        System.out.println("Updated account data: ");
        System.out.println(account);

        System.out.print("\nEnter a withdraw value: ");
        withdrawValue = sc.nextDouble();
        account.withdraw(withdrawValue);
        System.out.println("Updated account data: ");
        System.out.println(account);

        sc.close();
    }
}
