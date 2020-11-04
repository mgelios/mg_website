package mg.blog.service;

import mg.blog.dto.CategoryDto;
import mg.blog.entity.Category;
import mg.blog.mapper.CategoryMapper;
import mg.blog.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public Category getCategory(Long categoryId) {
        return categoryRepository.findById(categoryId).get();
    }

    public List<CategoryDto> getAllCategories() {
        return categoryRepository.findAll().stream()
                .map(CategoryMapper.INSTANCE::mapToDTO)
                .collect(Collectors.toList());
    }


    public void deleteCategory() {

    }

    public void updateCategory() {

    }

    public CategoryDto createCategory(CategoryDto categoryDto) {
        Category dbCategory = CategoryMapper.INSTANCE.mapToEntity(categoryDto);
        dbCategory = categoryRepository.save(dbCategory);
        return CategoryMapper.INSTANCE.mapToDTO(dbCategory);
    }
}
