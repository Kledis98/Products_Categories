package com.exercise.products_categories.repositories;

import com.exercise.products_categories.models.Category;
import com.exercise.products_categories.models.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends CrudRepository<Category,Long> {
    List<Category> findAll();



    // Retrieves a list of all categories for a particular product
    List<Category> findAllByProducts(Product product);

    // Retrieves a list of any categories a particular product
    // does not belong to.
    List<Category> findByProductsNotContains(Product product);

}
