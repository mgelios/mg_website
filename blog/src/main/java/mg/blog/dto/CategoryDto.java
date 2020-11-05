package mg.blog.dto;

import lombok.Data;

import java.util.List;

@Data
public class CategoryDto {

    private Long id;
    private String name;
    private String icon;
    private String description;
    private List<SubcategoryDto> subcategories;
}
