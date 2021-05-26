package com.desafio.comeia.pojos;


/**
 * @author Mattskywalker
 *
 * Classe modelo para a requisição; serve apenas para este proposito;
 */

public class RequestTransaction {

    private String accountDebitNumber;
    private String accountCreditNumber;
    private double transferValue;

    public RequestTransaction(String accountDebitNumber, String accountCreditNumber, double transferValue) {
        this.accountDebitNumber = accountDebitNumber;
        this.accountCreditNumber = accountCreditNumber;
        this.transferValue = transferValue;
    }

    public String getAccountDebitNumber() {
        return accountDebitNumber;
    }

    public void setAccountDebitNumber(String accountDebitNumber) {
        this.accountDebitNumber = accountDebitNumber;
    }

    public String getAccountCreditNumber() {
        return accountCreditNumber;
    }

    public void setAccountCreditNumber(String accountCreditNumber) {
        this.accountCreditNumber = accountCreditNumber;
    }

    public double getTransferValue() {
        return transferValue;
    }

    public void setTransferValue(double transferValue) {
        this.transferValue = transferValue;
    }
}
