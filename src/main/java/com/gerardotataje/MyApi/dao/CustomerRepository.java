package com.gerardotataje.MyApi.dao;

import com.gerardotataje.MyApi.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
