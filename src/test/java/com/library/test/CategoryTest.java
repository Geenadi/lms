package com.library.test;

import com.library.dao.CategoryDAO;
import com.library.model.Category;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CategoryTest {
    private CategoryDAO categoryDAO;

    @Before
    public void setUp() {
        categoryDAO = new CategoryDAO();
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testSaveCategory() {
        Category category = new Category("Fiction");
        categoryDAO.save(category);

        Category savedCategory = categoryDAO.get(category.getId());
        assertNotNull(savedCategory);
        assertEquals(category.getName(), savedCategory.getName());
    }

    @Test
    public void testUpdateCategory() {
        Category category = new Category("Fiction");
        categoryDAO.save(category);

        category.setName("Science Fiction");
        categoryDAO.update(category);

        Category updatedCategory = categoryDAO.get(category.getId());
        assertEquals("Science Fiction", updatedCategory.getName());
    }

    @Test
    public void testDeleteCategory() {
        Category category = new Category("Fiction");
        categoryDAO.save(category);

        categoryDAO.delete(category.getId());
        Category deletedCategory = categoryDAO.get(category.getId());
        assertNull(deletedCategory);
    }
}