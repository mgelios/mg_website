package mg.blog.controller;

import mg.blog.dto.ArticleDto;
import mg.blog.dto.Category;
import mg.blog.dto.Subcategory;
import mg.blog.service.ArticleService;
import mg.blog.service.CategoryService;
import mg.blog.service.SubcategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("/api/v1/blog")
public class BlogRestController {

    @Autowired
    private ArticleService articleService;
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private SubcategoryService subcategoryService;

    @GetMapping("/article/{id}")
    public Object getArticle(@PathVariable Long id) {
        return null;
    }

    @PostMapping("/article/{id}")
    public Object createArticle(@RequestBody ArticleDto articleDto) {
        return null;
    }

    @GetMapping("/category/all")
    public Object getAllCategories() {
        return categoryService.getAllCategories();
    }

    @GetMapping("/category/{id}")
    public Object getCategory(@PathVariable Long id) {
        return categoryService.getCategory(id);
    }

    @PostMapping("/category")
    public Object createCategory(@RequestBody Category category) {
        return categoryService.createCategory(category);
    }

    @GetMapping("/subcategory/{id}")
    public Object getSubcategory(@PathVariable Long id) {
        return null;
    }

    @PostMapping("/subcategory/{id}")
    public Object createSubcategory(@RequestBody Subcategory subcategory) {
        subcategory.getDescription();
        return null;
    }
}
