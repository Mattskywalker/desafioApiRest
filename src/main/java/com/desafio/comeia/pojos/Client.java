package com.desafio.comeia.pojos;


import com.desafio.comeia.enums.Type;
import net.bytebuddy.dynamic.loading.InjectionClassLoader;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "client")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)//FIXED
    private Integer id;
    @Column
    private Type userType;
    @Column
    private String document;
    @Column
    private String name;
    @Column
    private String address;
    @Column
    private String phoneNumber;
    @Column
    private String creationDate;
    @Column
    private double creditTransations;
    @Column
    private double debitTransations;


    public Client() {
    }

    public Client(Type userType, String document, String name, String address, String phoneNumber) {
        this.userType = userType;
        this.document = document;
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.creationDate = new Date().toString();
    }

    public Client(Integer id, Type userType, String document, String name,
                  String address, String phoneNumber, String creationDate) {
        this.id = id;
        this.userType = userType;
        this.document = document;
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.creationDate = creationDate;
    }

    public Client(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Type getUserType() {
        return userType;
    }

    public void setUserType(Type userType) {
        this.userType = userType;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }

    public Double getCreditTransations() {
        return creditTransations;
    }

    public void setCreditTransations(Double creditTransations) {
        this.creditTransations = creditTransations;
    }

    public Double getDebitTransations() {
        return debitTransations;
    }

    public void setDebitTransations(Double debitTransations) {
        this.debitTransations = debitTransations;
    }
}
