package com.exercise.products_categories.services;

import com.exercise.products_categories.models.Category;
import com.exercise.products_categories.models.Product;
import com.exercise.products_categories.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;


    public List<Category> allCategories() {
        return categoryRepository.findAll();
    }

    public Category addCategory(Category category) {
        return categoryRepository.save(category);
    }

    public Category findCategory(Long id) {
        return categoryRepository.findById(id).orElse(null);
    }

    public Category updateCategory(Category category) {
        return categoryRepository.save(category);
    }

    public List<Category> getAssignedCategories(Product product) {
        return categoryRepository.findAllByProducts(product);
    }

    public List<Category> getUnassignedCategories(Product product) {
        return categoryRepository.findByProductsNotContains(product);
    }
}