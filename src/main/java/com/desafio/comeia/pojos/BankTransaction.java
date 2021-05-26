package com.desafio.comeia.pojos;

import com.desafio.comeia.enums.TransactionType;

import javax.persistence.*;
import java.util.Date;

@Entity
@SequenceGenerator(
        name="sequence_ausencia",
        sequenceName="wf_sq_ausencia",
        allocationSize=1
)
public class BankTransaction {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column
    private Date transactionDate;
    @Column
    private Double value;
    @Column
    private TransactionType transactionType;
    /*@Column
    private Client debitClient;
    @Column
    private Client creditClient;*/
    @Column
    private Double operationValue;



    public BankTransaction() {
    }

    public BankTransaction(Double value,
                           TransactionType transactionType,Double operationValue) {
        this.value = value;
        this.transactionType = transactionType;
        /*this.debitClient = debitClient;
        this.creditClient = creditClient;*/
        this.operationValue = operationValue;
        this.transactionDate = new Date();
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

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public TransactionType getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(TransactionType transactionType) {
        this.transactionType = transactionType;
    }
}
