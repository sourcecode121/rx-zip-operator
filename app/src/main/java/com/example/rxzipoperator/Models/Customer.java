package com.example.rxzipoperator.Models;

/**
 * Created by Anand on 26/09/2016.
 */
public class Customer {
    private String name;
    private String id;

    public Customer(String name, String id){
        this.setName(name);
        this.setId(id);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
