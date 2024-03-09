package application;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        System.out.println("\nPath suggestion: src/file/input.csv");
        System.out.print("Enter file full path: ");
        String path = sc.next();
        Map<String, Integer> candidates = new HashMap<>();

        try(BufferedReader br = new BufferedReader(new FileReader(path))){
            String line = br.readLine();
            while(line != null){
                String[] separateValues = line.split(",");
                String candidate = separateValues[0];
                Integer numberOfVotes = Integer.valueOf(separateValues[1]);

                if(candidates.containsKey(candidate)){
                    candidates.put(candidate, candidates.get(candidate) + numberOfVotes);
                }
                else{
                    candidates.put(candidate, numberOfVotes);
                }

                line = br.readLine();
            }

            for( String key : candidates.keySet()){
                System.out.println(key + ": " + candidates.get(key));
            }
        }
        catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
