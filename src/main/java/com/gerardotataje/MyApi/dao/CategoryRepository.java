package com.gerardotataje.MyApi.dao;

import com.gerardotataje.MyApi.entity.Category;
import com.gerardotataje.MyApi.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin
public interface CategoryRepository extends JpaRepository<Category,Long> {
}
