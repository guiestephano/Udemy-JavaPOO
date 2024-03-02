package application;

import entities.Employee;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){

       Locale.setDefault(Locale.US);
       Scanner sc = new Scanner(System.in);

       List<Employee> list = new ArrayList<>();

        System.out.print("How many employees will be registered? ");
        int nEmployees = sc.nextInt();

        for(int i = 0; i < nEmployees; i++){
            System.out.println("\nEmployee #" + (i + 1) + ":");
            System.out.print("Id: ");
            int id = sc.nextInt();
            while(hasId(id, list)){
                System.out.println("This id already exist, try again!");
                System.out.print("Id: ");
                id = sc.nextInt();
            }
            System.out.print("Name: ");
            sc.nextLine();
            String name = sc.nextLine();
            System.out.print("Salary: ");
            double salary = sc.nextDouble();
            list.add(new Employee(id,name,salary));
        }

        System.out.print("\nEnter the employee id that will have salary increase: ");
        int id = sc.nextInt();
        if(position(id, list) > -1){
            int pos = position(id, list);
            System.out.print("Enter the percentage: ");
            double percentage = sc.nextDouble();
            list.get(pos).IncreaseSalary(percentage);
        }
        else{
            System.out.println("This id does not exist!");
        }

        System.out.println("\nList of employees:");
        for (Employee emp : list){
            System.out.println(emp);
        }

       sc.close();
    }
    static int position(int id,List<Employee> list){
        for(int i = 0; i < list.size(); i++){
            if(list.get(i).getId() == id){
                return i;
            }
        }
        return -1;
    }

    static boolean hasId(int id,List<Employee> employees){
        Employee employee = employees.stream().filter(emp -> emp.getId() == id).findFirst().orElse(null);
        return employee != null;
    }
}
