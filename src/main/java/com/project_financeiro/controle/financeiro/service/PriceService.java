package com.project_financeiro.controle.financeiro.service;

import com.project_financeiro.controle.financeiro.model.Category;
import com.project_financeiro.controle.financeiro.repository.CategoryRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PriceService {

    private final CategoryRepository categoryRepository;

    public PriceService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }
}
