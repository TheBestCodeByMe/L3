package com.example.laboratory3;

import javax.persistence.*;
import java.io.Serializable;

@Table(name = "customer")
public class Customer implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "zip")
    private int zip;
    @Column(name = "name")
    private String name;
    @Column(name = "firstaddress")
    private String firstAddress;
    @Column(name = "secondaddress")
    private String secondAddress;
    @Column(name = "numbFax")
    private int numbFax;
    @Column(name = "city")
    private String city;

    public Customer() {
    }

    public Customer(Integer id, int zip, String name, String firstAddress, String secondAddress, int numbFax, String city) {
        this.id = id;
        this.zip = zip;
        this.name = name;
        this.firstAddress = firstAddress;
        this.secondAddress = secondAddress;
        this.numbFax = numbFax;
        this.city = city;
    }

    public Customer(int zip, String name, String firstAddress, String secondAddress, int numbFax, String city) {
        this.zip = zip;
        this.name = name;
        this.firstAddress = firstAddress;
        this.secondAddress = secondAddress;
        this.numbFax = numbFax;
        this.city = city;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getZip() {
        return zip;
    }

    public void setZip(int zip) {
        this.zip = zip;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFirstAddress() {
        return firstAddress;
    }

    public void setFirstAddress(String firstAddress) {
        this.firstAddress = firstAddress;
    }

    public String getSecondAddress() {
        return secondAddress;
    }

    public void setSecondAddress(String secondAddress) {
        this.secondAddress = secondAddress;
    }

    public int getNumbFax() {
        return numbFax;
    }

    public void setNumbFax(int numbFax) {
        this.numbFax = numbFax;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}

