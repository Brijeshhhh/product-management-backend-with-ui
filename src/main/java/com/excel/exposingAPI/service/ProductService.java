package com.excel.exposingAPI.service;


import com.excel.exposingAPI.model.Product;
import com.excel.exposingAPI.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public Page<Product> findPaginated(Pageable pageable) {
        return productRepository.findAll(pageable);
    }
    public Product save(Product product) {
        productRepository.save(product);
        return product;
    }
    public Optional<Product> findById(Long id) {
        return productRepository.findById(id);
    }
    public void deleteById(Long id) {
        productRepository.deleteById(id);
    }


    public List<Product> findAll() {
        return productRepository.findAll();
    }
}
