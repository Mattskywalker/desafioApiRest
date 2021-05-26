package com.desafio.comeia.pojos;

import com.desafio.comeia.enums.TransactionType;

import javax.persistence.*;
import java.util.Date;

@Entity
public class BankTransaction {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column
    private Date transactionDate;// data é gerada quando a classe é criada;
    @Column
    private double value;
    @Column
    private TransactionType transactionType;
    @ManyToOne
    private Client debitClient;
    @ManyToOne
    private Client creditClient;
    @Column
    private double operationCost;// valor de custo da operação;



    public BankTransaction() {
    }

    public BankTransaction( double value, TransactionType transactionType,
                            Client debitClient, Client creditClient,
                            double operationCost
    ) {
        this.transactionDate = new Date();
        this.value = value;
        this.transactionType = transactionType;
        this.debitClient = debitClient;
        this.creditClient = creditClient;
        this.operationCost = operationCost;
    }




    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public TransactionType getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(TransactionType transactionType) {
        this.transactionType = transactionType;
    }

    @JoinColumn(name = "cliente_debitado")
    public Client getDebitClient() {
        return debitClient;
    }

    public void setDebitClient(Client debitClient) {
        this.debitClient = debitClient;
    }
    @JoinColumn(name = "cliente_creditado")
    public Client getCreditClient() {
        return creditClient;
    }

    public void setCreditClient(Client creditClient) {
        this.creditClient = creditClient;
    }

    public double getOperationCost() {
        return operationCost;
    }

    public void setOperationCost(double operationCost) {
        this.operationCost = operationCost;
    }
}
