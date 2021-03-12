package com.gerardotataje.MyApi.service;


import com.gerardotataje.MyApi.dao.CustomerRepository;
import com.gerardotataje.MyApi.dto.Purchase;
import com.gerardotataje.MyApi.dto.PurchaseResponse;
import com.gerardotataje.MyApi.entity.Customer;
import com.gerardotataje.MyApi.entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.UUID;

@Service
public class CheckoutServiceImpl implements CheckoutService{
    private CustomerRepository customerRepository;

    @Autowired
    public CheckoutServiceImpl(CustomerRepository customerRepository) {

        this.customerRepository = customerRepository;
    }

    @Override
    @Transactional
    public PurchaseResponse placeOrder(Purchase purchase) {
        String trackingNumber=getTrackingNumber();
        Order order=purchase.getOrder();
        order.setTrackingNumber(trackingNumber);
        order.setBillingAddress(purchase.getBillingAddress());
        order.setShippingAddress(purchase.getShippingAddress());
        purchase.getOrderItems().forEach(i->{
            order.addOrdenItem(i);
        });
        Customer customer=purchase.getCustomer();
        customer.addOrder(order);
        customerRepository.save(customer);
        return new PurchaseResponse(trackingNumber);
    }
    private String getTrackingNumber(){
        return UUID.randomUUID().toString();
    }
}

