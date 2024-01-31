package com.ijse.cmjd.posSystemBackend.service;

import com.ijse.cmjd.posSystemBackend.entity.Category;
import com.ijse.cmjd.posSystemBackend.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public Category findCategoryById(Long id) {
        return categoryRepository.findById(id).orElse(null);
    }

    @Override
    public Category createCategory(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public Category updateCategory(Long id, Category category) {
        Category existingCategory = categoryRepository.findById(id).orElse(null); //find the category by ID given by the user.

        if(existingCategory != null) { //if category is found in the Database
            existingCategory.setCategoryName(category.getCategoryName()); //update the name from user's input
            return categoryRepository.save(existingCategory);
        } else { // else return null
            return null;
        }
    }
}
