package com.gerardotataje.MyApi.dao;

import com.gerardotataje.MyApi.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin
public interface ProductRepository extends JpaRepository<Product,Long> {

    //QueryMethods

    Page<Product> findByCategoryId(Long id, Pageable pageable);

}
