package com.exercise.products_categories.controllers;

import com.exercise.products_categories.models.Category;
import com.exercise.products_categories.models.Product;
import com.exercise.products_categories.services.CategoryService;
import com.exercise.products_categories.services.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
public class MainController {
    @Autowired
    ProductService productService;

    @Autowired
    CategoryService categoryService;


    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("allProducts", productService.allProducts());
        model.addAttribute("allCategories", categoryService.allCategories());
        return "home";
    }

    @GetMapping("/product/new")
    public String newProduct(@ModelAttribute("product") Product product) {
        return "newProduct";
    }

    @PostMapping("/product/new")
    public String addProduct(@Valid @ModelAttribute("product") Product product, BindingResult result) {
        if (result.hasErrors()) {
            return "newProduct";
        } else {
            productService.addNew(product);
            return "redirect:/";
        }
    }


    @GetMapping("/category/new")
    public String newCategory(@ModelAttribute("category") Category category) {
        return "newCategory";
    }

    @PostMapping("/category/new")
    public String addCategory(@Valid @ModelAttribute("category") Category category, BindingResult result) {
        if (result.hasErrors()) {
            return "newCategory";
        } else {
            categoryService.addCategory(category);
            return "redirect:/";
        }
    }


    @GetMapping("/categories/{id}")
    public String categoryList(@PathVariable("id") Long id, Model model){
        Category category = categoryService.findCategory(id);
        model.addAttribute("category", category);
        model.addAttribute("assignedProducts",productService.getAssignedProducts(category));
        model.addAttribute("unassignedProducts", productService.getUnassignedProducts(category));
        return "showCategory";
    }


    @PostMapping("/categories/{id}")
    public String updateCategory(@PathVariable("id") Long id, @RequestParam(value="productId") Long productId, Model model ){
        Category category = categoryService.findCategory(id);
        Product product =productService.findProduct(productId);
        category.getProducts().add(product);
        categoryService.updateCategory(category);
        return "redirect:/categories/"+id;
    }

    @GetMapping("/products/{id}")
    public String productList(@PathVariable("id") Long id, Model model){
        Product product = productService.findProduct(id);
        model.addAttribute("product", product);
        model.addAttribute("assignedCategories",categoryService.getAssignedCategories(product));
        model.addAttribute("unassignedCategories",categoryService.getUnassignedCategories(product));
        return "showProduct";
    }



    @PostMapping("/products/{id}")
    public String updateProduct(@PathVariable("id") Long id, @RequestParam(value = "categoryId") Long categoryId, Model model ){
        Product product = productService.findProduct(id);
        Category category = categoryService.findCategory(categoryId);
        product.getCategories().add(category);
        productService.updateProduct(product);
        return "redirect:/products/"+id;
    }

}
