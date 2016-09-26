package com.example.rxzipoperator.models;

/**
 * Created by Anand on 26/09/2016.
 */
public class Order {
    private String id;
    private int quantity;

    public Order(String id, int quantity){
        this.setId(id);
        this.setQuantity(quantity);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
