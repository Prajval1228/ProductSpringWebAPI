package com.pc.ProductSpringWeb;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    private ProductDB db;

    // Create or Update Product
    public Product saveProduct(Product product) {
        return db.save(product);
    }

    // Get All Products
    public List<Product> getAllProducts() {
        return db.findAll();
    }

    // Get Product by ID
    public Optional<Product> getProductById(int id) {
        return db.findById(id);
    }

    // Get Products by Name
    public List<Product> getProductsByName(String name) {
        return db.findByName(name);
    }

    // Get Products by Type
    public List<Product> getProductsByType(String type) {
        return db.findByType(type);
    }

    // Get Products by Place
    public List<Product> getProductsByPlace(String place) {
        return db.findByPlace(place);
    }

    // Get Products by Warranty
    public List<Product> getProductsByWarranty(int warranty) {
        return db.findByWarranty(warranty);
    }

    // Update Product
    public Product updateProduct(int id, Product product) {
        if (db.existsById(id)) {
            product.setId(id);
            return db.save(product);
        } else {
            return null;
        }
    }

    // Delete Product
    public boolean deleteProduct(int id) {
        if (db.existsById(id)) {
            db.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
