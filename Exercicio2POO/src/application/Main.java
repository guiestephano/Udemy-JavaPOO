package application;

import entities.Employee;

import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        String name;
        double grossSalary, tax, percentage;
        Employee employee;

        System.out.print("Name: ");
        name = sc.nextLine();
        System.out.print("Gross salary: ");
        grossSalary = sc.nextDouble();
        System.out.print("Tax: ");
        tax = sc.nextDouble();

        employee = new Employee(name, grossSalary, tax);

        System.out.println("\nEmployee: " + employee + "\n");

        System.out.print("Which percentage to increase salary? ");
        percentage = sc.nextDouble();
        employee.increaseSalary(percentage);

        System.out.println("\nUpdated data: " + employee);

        sc.close();
    }
}
