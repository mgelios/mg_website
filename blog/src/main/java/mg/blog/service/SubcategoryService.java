package mg.blog.service;

import mg.blog.repository.SubcategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SubcategoryService {

    @Autowired
    private SubcategoryRepository subcategoryRepository;

    public void createSubcategory(Long categoryId) {

    }

    public void deleteSubcategory(Long categoryId) {

    }
}
