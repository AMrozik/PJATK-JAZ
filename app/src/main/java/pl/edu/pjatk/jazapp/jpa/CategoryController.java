package pl.edu.pjatk.jazapp.jpa;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
@RequestScoped
public class CategoryController {

    @Inject
    CategoryRepository categoryRepository;

    public List<CategoryEntity> CategoryList(){
        return categoryRepository.findAll();
    }

}
