package application;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args){
        Set<Integer> setA = new HashSet<>();
        Set<Integer> setB = new HashSet<>();
        Set<Integer> setC = new HashSet<>();

        Set<Integer> setTotal = new HashSet<>();
        Scanner sc = new Scanner(System.in);
        int nStudents;

        System.out.print("How many students for course A?: ");
        nStudents = sc.nextInt();
        for(int i = 0; i < nStudents; i++){
            setA.add(sc.nextInt());
        }

        System.out.print("How many students for course B?: ");
        nStudents = sc.nextInt();
        for(int i = 0; i < nStudents; i++){
            setA.add(sc.nextInt());
        }

        System.out.print("How many students for course C?: ");
        nStudents = sc.nextInt();
        for(int i = 0; i < nStudents; i++){
            setA.add(sc.nextInt());
        }

        setTotal.addAll(setA);
        setTotal.addAll(setB);
        setTotal.addAll(setC);
        System.out.println("Total students: " + setTotal.size());

        sc.close();
    }
}
