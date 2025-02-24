package com.excel.exposingAPI.repository;

import com.excel.exposingAPI.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}