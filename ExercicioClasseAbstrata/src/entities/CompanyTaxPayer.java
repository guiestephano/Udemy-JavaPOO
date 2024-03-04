package entities;

public class CompanyTaxPayer extends TaxPayer{

    private Integer numberOfEmployees;

    public CompanyTaxPayer(String name, Double annualIncome,Integer numberOfEmployees) {
        super(name, annualIncome);
        this.numberOfEmployees = numberOfEmployees;
    }

    public Integer getNumberOfEmployees() {
        return numberOfEmployees;
    }

    @Override
    public Double totalTax() {
        if(numberOfEmployees > 10){
            return annualIncome * 0.14;
        }
        return annualIncome * 0.16;
    }
}
