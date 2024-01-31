package com.ijse.cmjd.posSystemBackend.service;

import com.ijse.cmjd.posSystemBackend.controller.CategoryController;
import com.ijse.cmjd.posSystemBackend.entity.Category;
import com.ijse.cmjd.posSystemBackend.entity.Product;
import com.ijse.cmjd.posSystemBackend.repository.CategoryRepository;
import com.ijse.cmjd.posSystemBackend.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
  @Autowired
  private ProductRepository productRepository;
  @Autowired
  private CategoryRepository categoryRepository;

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product createProduct(Product product) {
        Category category = categoryRepository.findById(product.getId()).orElse(null);

        if (category != null) {
           // Product product = new Product();
            CategoryController cc=new CategoryController();
            product.setProductName(product.getProductName());
            product.setUnitPrice(product.getUnitPrice());
            product.setInStockQTY(product.getInStockQTY());
            product.setCategory(cc.getCategoryById(product.getId()));

            return productRepository.save(product);
        } else {
            return null;
        }
    }


        @Override
    public Product getProductById(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    @Override
    public Product updateProduct(Long id, Product product) {
        Product existingProduct = productRepository.findById(id).orElse(null);

        if(existingProduct != null) {
            existingProduct.setProductName(product.getProductName());
            existingProduct.setCategory(product.getCategory());
            existingProduct.setUnitPrice(product.getUnitPrice());
            existingProduct.setInStockQTY(product.getInStockQTY());

            return productRepository.save(existingProduct);
        } else {
            return null;
        }
    }

    @Override
    public List<Product> getProductsByCategory(Long id) {
        Category category = categoryRepository.findById(id).orElse(null);

        if(category != null) {
            return productRepository.findProductsByCategory(category);
        } else {
            return null;
        }
    }
}
