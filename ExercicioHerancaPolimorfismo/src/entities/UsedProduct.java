package entities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public final class UsedProduct extends Product{

    LocalDate manufactureDate;

    public UsedProduct(String name, Double price, LocalDate manufactureDate){
        super(name,price);
        this.manufactureDate = manufactureDate;
    }

    public LocalDate getManufactureDate() {
        return manufactureDate;
    }

    @Override
    public String priceTag(){
        return name + " (used) $ " + String.format("%.2f", price) +
                " (Manufacture date: " + manufactureDate.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) + ")";
    }
}
