package model.services;

import model.entities.Contract;
import model.entities.Installment;
import model.model.interfaces.OnlinePaymentService;

public class ContractService {
    private OnlinePaymentService paymentService;
    public ContractService(OnlinePaymentService paymentService){
        this.paymentService = paymentService;
    }
    public void processContract(Contract contract, Integer months){
        double amount = contract.getTotalValue()/months;
        for(int i = 1; i <= months; i++){
            double taxAmount = paymentService.paymentFee(paymentService.interest(amount,i));
            contract.addInstallment(new Installment(contract.getDate().plusMonths(i),taxAmount));
        }
    }
}
