package com.library.service;

import com.library.dao.CategoryDAO; 
import com.library.model.Category;

public class CategoryService {
    private final CategoryDAO categoryDAO;

    public CategoryService() {
        categoryDAO = new CategoryDAO();
    }

    public void createCategory(Category category) {
        categoryDAO.save(category);
    }
}