package com.library.controller;

import com.library.model.Category;
import com.library.service.CategoryService;


public class CategoryController {
    private final CategoryService categoryService;

    public CategoryController() {
        categoryService = new CategoryService();
    }

    public void createCategory(Category category) {
        categoryService.createCategory(category);
    }
}