package application;

import entities.CompanyTaxPayer;
import entities.IndividualTaxPayer;
import entities.TaxPayer;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        List<TaxPayer> list = new ArrayList<>();

        System.out.print("Enter the number of tax payers: ");
        int number = sc.nextInt();
        for(int i = 1; i <= number; i++){
            boolean invalidChoice;
            System.out.println("Tax payer #" + i + " data:");
            do{
                invalidChoice = false;
                System.out.print("Individual or company(i/c): ");
                char choice = sc.next().toLowerCase().charAt(0);
                if(choice == 'i'){
                    System.out.print("Name: ");
                    sc.nextLine();
                    String name = sc.nextLine();
                    System.out.print("Annual income: ");
                    Double annualIncome = sc.nextDouble();
                    System.out.print("Health expenditures: ");
                    Double healthExpenditures = sc.nextDouble();
                    list.add(new IndividualTaxPayer(name,annualIncome,healthExpenditures));
                } else if (choice == 'c') {
                    System.out.print("Name: ");
                    sc.nextLine();
                    String name = sc.nextLine();
                    System.out.print("Annual income: ");
                    Double annualIncome = sc.nextDouble();
                    System.out.print("Number of employees: ");
                    Integer numberEmployees = sc.nextInt();
                    list.add(new CompanyTaxPayer(name,annualIncome,numberEmployees));
                }else {
                    System.out.println("\nInvalid choice, try again!");
                    invalidChoice = true;
                }
            }while (invalidChoice);
        }

        double totalTaxes = 0;
        System.out.println("\nTAXES PAID:");
        for(TaxPayer tp : list){
            System.out.println(tp);
            totalTaxes += tp.totalTax();
        }

        System.out.print("\nTotal taxes: $ " + String.format("%.2f", totalTaxes));
        sc.close();
    }
}
