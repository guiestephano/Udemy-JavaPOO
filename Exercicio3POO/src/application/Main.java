package application;

import entities.Student;

import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        String name;
        double firstTrimester, secondTrimester, thirdTrimester;
        Student student;

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        name = sc.nextLine();
        firstTrimester = sc.nextDouble();
        secondTrimester = sc.nextDouble();
        thirdTrimester = sc.nextDouble();

        student = new Student(name, firstTrimester, secondTrimester, thirdTrimester);

        System.out.println(student);
        sc.close();
    }
}
