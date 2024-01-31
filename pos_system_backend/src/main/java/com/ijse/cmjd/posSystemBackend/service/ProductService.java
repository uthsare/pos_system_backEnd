package com.ijse.cmjd.posSystemBackend.service;

import com.ijse.cmjd.posSystemBackend.entity.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {
    List<Product>getAllProducts();
    Product createProduct(Product product);
    Product getProductById(Long id);
    Product updateProduct(Long id, Product product);
    List<Product> getProductsByCategory(Long id);
}
