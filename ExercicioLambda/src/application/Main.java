package application;

import entities.Employee;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        System.out.println("\nPath suggestion: src/file/input.csv");
        System.out.print("Enter full file path: ");
        String path = sc.next();

        List<Employee> employees = new ArrayList<>();

        try(BufferedReader br = new BufferedReader(new FileReader(path))){
            String line = br.readLine();
            while(line != null){
                String[] fields = line.split(",");
                employees.add(new Employee(fields[0], fields[1], Double.parseDouble(fields[2])));
                line = br.readLine();
            }

            System.out.print("Enter salary: ");
            Double salary = sc.nextDouble();

            List<String> emails = employees.stream().filter(e -> e.getSalary() > salary).map(e -> e.getEmail()).sorted().toList();

            Double sumSalary = employees.stream().filter(e -> e.getName().toUpperCase().charAt(0) == 'M').map(e -> e.getSalary()).reduce(0.0, (x, y) -> x + y);

            System.out.println("Email of people whose salary is more than " + String.format("%.2f", salary) + ":");
            emails.forEach(System.out::println);
            System.out.println("Sum of salary of people whose name starts with 'M': " + String.format("%.2f", sumSalary));
        }
        catch (IOException e){
            System.out.println("Error: " + e.getMessage());
        }
    }
}
