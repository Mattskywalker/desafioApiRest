package com.desafio.comeia.pojo;


import com.desafio.comeia.enums.Type;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ClientTable")
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
    private String aderess;
    @Column
    private String phoneNumber;


    public Client(String id, Type userType, String document, String name, String aderess, String phoneNumber) {
        this.id = id;
        this.userType = userType;
        this.document = document;
        this.name = name;
        this.aderess = aderess;
        this.phoneNumber = phoneNumber;
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

    public String getAderess() {
        return aderess;
    }

    public void setAderess(String aderess) {
        this.aderess = aderess;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
