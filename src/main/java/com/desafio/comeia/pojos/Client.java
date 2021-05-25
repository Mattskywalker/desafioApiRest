package com.desafio.comeia.pojos;


import com.desafio.comeia.enums.Type;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "client")
public class Client {

    @Id
    private String id;
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

    public Client() {
    }

    public Client(String id, Type userType, String document, String name, String address, String phoneNumber) {
        this.id = id;
        this.userType = userType;
        this.document = document;
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.creationDate = new Date().toString();
    }

    public Client(String id, Type userType,
                  String document, String name,
                  String address, String phoneNumber,
                  List<Account> bankAccounts
    ) {
        this.id = id;
        this.userType = userType;
        this.document = document;
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.creationDate = new Date().toString();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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
}
