package com.indhumotors.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.indhumotors.entity.Product;
import com.indhumotors.repository.ProductRepository;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    // GET ALL PRODUCTS
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    // GET PRODUCT BY ID
    public Product getProductById(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found with id: " + id));
    }

    // CREATE PRODUCT
    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    // UPDATE PRODUCT
    public Product updateProduct(Long id, Product productDetails) {

        Product product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found with id: " + id));

        product.setProductName(productDetails.getProductName());
        product.setCategory(productDetails.getCategory());
        product.setBrand(productDetails.getBrand());
        product.setModel(productDetails.getModel());
        product.setCapacity(productDetails.getCapacity());
        product.setPrice(productDetails.getPrice());
        product.setWarranty(productDetails.getWarranty());
        product.setStock(productDetails.getStock());
        product.setAvailable(productDetails.getAvailable());

        return productRepository.save(product);
    }

    // DELETE PRODUCT
    public void deleteProduct(Long id) {

        if (!productRepository.existsById(id)) {
            throw new RuntimeException("Product not found with id: " + id);
        }

        productRepository.deleteById(id);
    }
}