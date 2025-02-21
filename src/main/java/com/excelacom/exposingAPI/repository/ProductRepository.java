package com.excelacom.exposingAPI.repository;

import com.excelacom.exposingAPI.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}