package com.pc.ProductSpringWeb;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ProductController {

    @Autowired
    private ProductService service;

    // Create a new product
    @PostMapping("/products")
    public ResponseEntity<Product> createProduct(@RequestBody Product product) {
        Product savedProduct = service.saveProduct(product);
        return new ResponseEntity<>(savedProduct, HttpStatus.CREATED);
    }

    // Get all products
    @GetMapping("/products")
    public List<Product> getAllProducts() {
        return service.getAllProducts();
    }

    // Get a product by ID
    @GetMapping("/products/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable("id") int id) {
        Optional<Product> product = service.getProductById(id);
        return product.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Get products by name
    @GetMapping("/products/name/{name}")
    public List<Product> getProductsByName(@PathVariable("name") String name) {
        return service.getProductsByName(name);
    }

    // Get products by type
    @GetMapping("/products/type/{type}")
    public List<Product> getProductsByType(@PathVariable("type") String type) {
        return service.getProductsByType(type);
    }

    // Get products by place
    @GetMapping("/products/place/{place}")
    public List<Product> getProductsByPlace(@PathVariable("place") String place) {
        return service.getProductsByPlace(place);
    }

    // Get products by warranty
    @GetMapping("/products/warranty/{warranty}")
    public List<Product> getProductsByWarranty(@PathVariable("warranty") int warranty) {
        return service.getProductsByWarranty(warranty);
    }

    // Update a product by ID
    @PutMapping("/products/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable("id") int id, @RequestBody Product product) {
        Product updatedProduct = service.updateProduct(id, product);
        return updatedProduct != null ? new ResponseEntity<>(updatedProduct, HttpStatus.OK) : ResponseEntity.notFound().build();
    }

    // Delete a product by ID
    @DeleteMapping("/products/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable("id") int id) {
        boolean isRemoved = service.deleteProduct(id);
        return isRemoved ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}
