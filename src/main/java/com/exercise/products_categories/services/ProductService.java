package com.exercise.products_categories.services;

import com.exercise.products_categories.models.Category;
import com.exercise.products_categories.models.Product;
import com.exercise.products_categories.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public List<Product> allProducts() {
        return productRepository.findAll();
    }

    public Product getById(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    public Product addNew(Product product) {
        return productRepository.save(product);
    }

    public List<Product> getAssignedProducts(Category category) {
        return productRepository.findAllByCategories(category);
    }

    public List<Product> getUnassignedProducts(Category category) {
        return productRepository.findByCategoriesNotContains(category);
    }

    public Product findProduct(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    public Product updateProduct(Product product) {
        return productRepository.save(product);
    }
}

