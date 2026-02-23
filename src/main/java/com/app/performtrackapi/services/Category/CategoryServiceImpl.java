package com.app.performtrackapi.services.Category;

import com.app.performtrackapi.dtos.Category.CategoryDto;
import com.app.performtrackapi.dtos.Category.CategoryResponseDto;
import com.app.performtrackapi.entities.Category;
import com.app.performtrackapi.entities.Evaluation;
import com.app.performtrackapi.exceptions.ResourceNotFound;
import com.app.performtrackapi.mappers.CategoryMapper;
import com.app.performtrackapi.repositories.CategoryRepository;
import com.app.performtrackapi.repositories.EvaluationRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;
    private final EvaluationRepository evaluationRepository;
    private final CategoryMapper categoryMapper;

    public CategoryServiceImpl(CategoryMapper categoryMapper, CategoryRepository categoryRepository, EvaluationRepository evaluationRepository) {
        this.categoryRepository = categoryRepository;
        this.evaluationRepository = evaluationRepository;
        this.categoryMapper = categoryMapper;
    }

    @Override
    public CategoryResponseDto getCategoryById(UUID id) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFound("Category not found"));

        return categoryMapper.toResponseDto(category);
    }

    @Override
    public CategoryResponseDto createCategory(CategoryDto categoryDto) {
        Evaluation evaluation = evaluationRepository.findById(categoryDto.getEvaluationId())
                .orElseThrow(() -> new ResourceNotFound("Evaluation not found"));

        Category category = categoryMapper.toEntity(categoryDto);
        category.setEvaluation(evaluation);

        // Auto-calculate order_index if not provided
        if (categoryDto.getOrder_index() == null) {
            int count = categoryRepository.countByEvaluation(evaluation);
            category.setOrder_index(count + 1);
        }

        Category savedCategory = categoryRepository.save(category);

        return categoryMapper.toResponseDto(savedCategory);
    }

    @Override
    public CategoryResponseDto updateCategory(UUID id, CategoryDto categoryDto) {

        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFound("Category not found"));

        if (categoryDto.getEvaluationId() != null) {
            Evaluation evaluation = evaluationRepository.findById(categoryDto.getEvaluationId())
                    .orElseThrow(() -> new ResourceNotFound("Evaluation not found"));
            category.setEvaluation(evaluation);
        }

        if (categoryDto.getName() != null) {
            category.setName(categoryDto.getName());
        }

        if (categoryDto.getWeight() != null) {
            category.setWeight(categoryDto.getWeight());
        }

        if (categoryDto.getOrder_index() != null) {
            category.setOrder_index(categoryDto.getOrder_index());
        }

        Category updatedCategory = categoryRepository.save(category);

        return categoryMapper.toResponseDto(updatedCategory);
    }

    @Override
    @Transactional
    public void deleteCategory(UUID id) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFound("Category not found"));

        Evaluation evaluation = category.getEvaluation();
        categoryRepository.deleteById(id);

        // Re-index remaining categories
        reindexCategories(evaluation);
    }

    @Override
    @Transactional
    public void reorderCategory(UUID categoryId, String direction) {
        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new ResourceNotFound("Category not found"));

        Evaluation evaluation = category.getEvaluation();

        // Step 1: Ensure clean indexing before swapping
        List<Category> categories = reindexCategories(evaluation);

        int currentIndex = -1;
        for (int i = 0; i < categories.size(); i++) {
            if (categories.get(i).getId().equals(categoryId)) {
                currentIndex = i;
                break;
            }
        }

        if (currentIndex == -1) return;

        int swapIndex;
        if ("up".equals(direction)) {
            if (currentIndex == 0) return;
            swapIndex = currentIndex - 1;
        } else if ("down".equals(direction)) {
            if (currentIndex == categories.size() - 1) return;
            swapIndex = currentIndex + 1;
        } else {
            throw new ResourceNotFound("Invalid direction. Use 'up' or 'down'.");
        }

        // Swap order_index values
        Category current = categories.get(currentIndex);
        Category swap = categories.get(swapIndex);

        Integer tempOrder = current.getOrder_index();
        current.setOrder_index(swap.getOrder_index());
        swap.setOrder_index(tempOrder);

        categoryRepository.save(current);
        categoryRepository.save(swap);
    }

    private List<Category> reindexCategories(Evaluation evaluation) {
        List<Category> categories = categoryRepository.findByEvaluationOrderByOrderIndexAsc(evaluation);
        for (int i = 0; i < categories.size(); i++) {
            categories.get(i).setOrder_index(i + 1);
        }
        return categoryRepository.saveAll(categories);
    }
}

