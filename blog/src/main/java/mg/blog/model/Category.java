package mg.blog.model;

import lombok.Data;

import java.util.List;

@Data
public class Category {

    private Long id;
    private String name;
    private String subcategory;
    private List<Subcategory> subcategories;
}
