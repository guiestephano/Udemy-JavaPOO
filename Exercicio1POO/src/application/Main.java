package application;
import entities.Rectangle;

import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        double width, height;
        Rectangle rectangle;

        System.out.println("Enter rectangle width and height:");
        width = sc.nextDouble();
        height = sc.nextDouble();
        rectangle = new Rectangle(width,height);
        System.out.printf("AREA = %.2f%n", rectangle.area());
        System.out.printf("PERIMETER = %.2f%n", rectangle.perimeter());
        System.out.printf("DIAGONAL = %.2f%n", rectangle.diagonal());
        sc.close();
    }
}