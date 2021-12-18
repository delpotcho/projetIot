package org.eheio.projet.iot.service;

import org.eheio.projet.iot.model.Category;
import org.eheio.projet.iot.model.Category;
import org.eheio.projet.iot.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface CategoryService {
    public List<Category> getAllCategories();

    public Category getCategoryById(UUID id);

    public void deleteCategory(Category category);

    public void addCaterogy(Category category);

    public void updateCategory(Category category);

}
