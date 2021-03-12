package com.gerardotataje.MyApi.dto;

import com.gerardotataje.MyApi.entity.Address;
import com.gerardotataje.MyApi.entity.Customer;
import com.gerardotataje.MyApi.entity.Order;
import com.gerardotataje.MyApi.entity.OrderItem;
import lombok.Data;

import java.util.Set;

@Data
public class Purchase {
    Customer customer;
    Order order;
    Address shippingAddress;
    Address billingAddress;
    Set<OrderItem> orderItems;
}
