package mg.blog.service;

import mg.blog.dbentity.CategoryDBEntity;
import mg.blog.mapper.CategoryMapper;
import mg.blog.model.Category;
import mg.blog.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public CategoryDBEntity getCategory(Long categoryId) {
        return categoryRepository.findById(categoryId).get();
    }

    public void deleteCategory() {

    }

    public void updateCategory() {

    }

    public Category createCategory(Category category) {
        CategoryDBEntity dbCategory = CategoryMapper.INSTANCE.mapToEntity(category);
        dbCategory = categoryRepository.save(dbCategory);
        return CategoryMapper.INSTANCE.mapToDTO(dbCategory);
    }
}
