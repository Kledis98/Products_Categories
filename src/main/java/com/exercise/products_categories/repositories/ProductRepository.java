package com.exercise.products_categories.repositories;

import com.exercise.products_categories.models.Category;
import com.exercise.products_categories.models.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends CrudRepository<Product,Long> {

    List<Product> findAll();
    Product findByIdIs(Long id);

    // Retrieves a list of all products for a particular category
    List<Product> findAllByCategories(Category category);

    // Retrieves a list of any product a particular category
    // does not belong to.
    List<Product> findByCategoriesNotContains(Category category);

}
