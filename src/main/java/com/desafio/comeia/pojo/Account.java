package com.desafio.comeia.pojo;

import javax.persistence.*;

@Entity
@Table(name = "bankAccount", schema = "apicomeiarepository")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;
    @ManyToOne
    private Client owner;

    @Column
    private String accountNumber;
    @Column
    private double balance;

    public Account() {
    }

    public Account(String id, Client owner, String accountNumber, double balance) {
        this.id = id;
        this.owner = owner;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @JoinColumn(name = "ownerAcount")
    public Client getOwner() {
        return owner;
    }

    public void setOwner(Client owner) {
        this.owner = owner;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
