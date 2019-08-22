package mg.blog.controller;

import mg.blog.service.ArticleService;
import mg.blog.service.CategoryService;
import mg.blog.service.SubcategoryService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/blog")
public class BlogRestController {

    private ArticleService articleService;
    private CategoryService categoryService;
    private SubcategoryService subcategoryService;

    @GetMapping("/article/{id}")
    public Object getArticle(@PathVariable Long id) {
        return null;
    }

    @PostMapping("/article/{id}")
    public Object createArticle(@PathVariable Long id) {
        return null;
    }

    @GetMapping("/category/{id}")
    public Object getCategory(@PathVariable Long id) {
        return categoryService.getCategory(id);
    }

    @PostMapping("/category/{id}")
    public Object createCategory(@PathVariable Long id) {
        return null;
    }

    @GetMapping("/subcategory/{id}")
    public Object getSubcategory(@PathVariable Long id) {
        return null;
    }

    @PostMapping("/subcategory/{id}")
    public Object createSubcategory(@PathVariable Long id) {
        return null;
    }
}
