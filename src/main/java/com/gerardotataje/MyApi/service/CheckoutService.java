package com.gerardotataje.MyApi.service;

import com.gerardotataje.MyApi.dto.Purchase;
import com.gerardotataje.MyApi.dto.PurchaseResponse;

public interface CheckoutService {
    PurchaseResponse placeOrder(Purchase purchase);
}
