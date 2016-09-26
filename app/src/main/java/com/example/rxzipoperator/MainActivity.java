package com.example.rxzipoperator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.rxzipoperator.Models.Customer;
import com.example.rxzipoperator.Models.CustomerOrderInfo;
import com.example.rxzipoperator.Models.Order;

import java.util.UUID;

import rx.Observable;
import rx.Scheduler;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func0;
import rx.functions.Func2;
import rx.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Observable.zip(getCustomer(), getOrder(), new Func2<Customer, Order, CustomerOrderInfo>() {
            @Override
            public CustomerOrderInfo call(Customer customer, Order order) {
                return new CustomerOrderInfo(customer.getId(), order.getId());
            }
        })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<CustomerOrderInfo>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(CustomerOrderInfo customerOrderInfo) {
                Log.d("Rx", "Customer Info");
            }
        });
    }

    public Observable<Customer> getCustomer(){
        return Observable.defer(new Func0<Observable<Customer>>() {
            @Override
            public Observable<Customer> call() {
                return Observable.just(new Customer("Customer name", UUID.randomUUID().toString()));
            }
        });
    }

    public Observable<Order> getOrder(){
        return Observable.defer(new Func0<Observable<Order>>() {
            @Override
            public Observable<Order> call() {
                return Observable.just(new Order(UUID.randomUUID().toString(), 1000));
            }
        });
    }
}
