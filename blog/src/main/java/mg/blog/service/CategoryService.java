package mg.blog.service;

import mg.blog.dbentity.CategoryDBEntity;
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
}
