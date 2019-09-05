package mg.blog.dbentity;

import lombok.Data;

import javax.persistence.OneToMany;
import java.util.List;

@Data
public class CategoryDBEntity {

    private Long id;
    private String name;
    private String description;
    @OneToMany
    private List<SubcategoryDBEntity> subcategories;
}
