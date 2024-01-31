package com.ijse.cmjd.posSystemBackend.controller;



import com.ijse.cmjd.posSystemBackend.entity.Product;
import com.ijse.cmjd.posSystemBackend.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*") //allowing cross origin to all
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/product")
    public ResponseEntity<List<Product>> getAllProducts() {
        return ResponseEntity.status(200).body(productService.getAllProducts());
    }

    @PostMapping("/product")
    public ResponseEntity<Product> createProduct(@RequestBody Product product) {

            return ResponseEntity.status(201).body(productService.createProduct(product));


        }


    @GetMapping("/product/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id) {
        Product product = productService.getProductById(id);

        if(product != null) {
            return ResponseEntity.status(HttpStatus.OK).body(product); //Return 200 with Body
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null); //Return 404
        }
    }

    @PutMapping("/product/{id}")
    public Product updateProduct(@PathVariable Long id, @RequestBody Product product) {
        return productService.updateProduct(id, product);
    }

    @GetMapping("/categories/{id}/product")
    public ResponseEntity<List<Product>> getProductsByCategory(@PathVariable Long id) {
        return ResponseEntity.ok().body(productService.getProductsByCategory(id));
    }

}
