package application;

import model.entities.Contract;
import model.entities.Installment;
import model.services.ContractService;
import model.services.PayPalService;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter contract data: ");
        System.out.print("Number: ");
        int number = sc.nextInt();
        System.out.print("Date (DD/MM/YYYY): ");
        LocalDate date = LocalDate.parse(sc.next(),DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        System.out.print("Contract amount: ");
        double amount = sc.nextDouble();
        System.out.print("Installments number: ");
        int months = sc.nextInt();

        Contract contract = new Contract(number,date,amount);
        ContractService cs = new ContractService(new PayPalService());

        cs.processContract(contract,months);

        System.out.println("\nInstallments");
        for(Installment installment : contract.getInstallments()){
            System.out.println(installment);
        }
        sc.close();
    }
}
