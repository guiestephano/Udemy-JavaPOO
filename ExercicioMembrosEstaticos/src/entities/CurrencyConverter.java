package entities;

public class CurrencyConverter {
    public static final double IOF = 6.0 / 100.0;

    public static double amount(double dolarValue, double quantity){
        double totalNoTax = dolarValue * quantity;
        double totalWithTax = totalNoTax + (totalNoTax * IOF);
        return totalWithTax;
    }
}
