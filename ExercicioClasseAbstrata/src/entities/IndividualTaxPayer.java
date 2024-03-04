package entities;

public class IndividualTaxPayer extends TaxPayer{
    private Double healthExpenditures;

    public IndividualTaxPayer(String name, Double annualIncome, Double healthExpenditures){
        super(name,annualIncome);
        this.healthExpenditures = healthExpenditures;
    }

    public Double getHealthExpenditures() {
        return healthExpenditures;
    }

    @Override
    public Double totalTax(){
        if(annualIncome >= 20000.00){
            return (annualIncome * 0.25) - (healthExpenditures * 0.5);
        }
        else{
            return (annualIncome * 0.15) - (healthExpenditures * 0.5);
        }
    }
}
