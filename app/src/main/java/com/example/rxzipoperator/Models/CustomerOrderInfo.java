package com.example.rxzipoperator.models;

/**
 * Created by Anand on 26/09/2016.
 */
public class CustomerOrderInfo {
    private String customerId;
    private String orderId;

    public CustomerOrderInfo(String customerId, String orderId){
        this.customerId = customerId;
        this.orderId = orderId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }
}
