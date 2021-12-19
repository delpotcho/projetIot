package org.eheio.projet.iot.service.implementation;

import org.eheio.projet.iot.dao.CategoryRepository;
import org.eheio.projet.iot.model.Category;
import org.eheio.projet.iot.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.UUID;

public class CategoryServiceImp implements CategoryService {
    @Autowired
   private CategoryRepository categoryRepository;
    @Override
    public List<Category> getAllCategories() {
        return null;
    }

    @Override
    public Category getCategoryById(UUID id) {
        return null;
    }

    @Override
    public void deleteCategory(Category category) {

    }

    @Override
    public void addCaterogy(Category category) {

    }

    @Override
    public void updateCategory(Category category) {

    }
}
