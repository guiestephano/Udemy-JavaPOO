package application;

import model.entities.Product;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Main {

    public static void main(String[] args){
        File path1 = new File("src/File/input.csv");
        boolean newFolder = new File("src/File/out/").mkdir();
        File path2 = new File("src/File/out/summary.csv");
        Locale.setDefault(Locale.US);
        List<Product> list = new ArrayList<>();

        try(BufferedReader br = new BufferedReader(new FileReader(path1))){
            String line = br.readLine();
            while(line != null){
                String[] strAux = line.split(",");
                String name = strAux[0];
                Double value = Double.valueOf(strAux[1]);
                Integer quantity = Integer.valueOf(strAux[2]);
                list.add(new Product(name,value,quantity));
                line = br.readLine();
            }

            try(BufferedWriter bw = new BufferedWriter(new FileWriter(path2))){
               for(Product product : list){
                   String writeLine = product.getName() + "," + String.format("%.2f",product.totalValue());
                   bw.write(writeLine);
                   bw.newLine();
               }
            }
            catch (IOException e){
                System.out.println("Error: " + e.getMessage());
            }
        }
        catch (IOException e){
            System.out.println("Error: " + e.getMessage());
        }
    }
}
