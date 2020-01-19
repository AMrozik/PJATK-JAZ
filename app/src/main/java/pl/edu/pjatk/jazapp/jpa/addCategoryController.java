package pl.edu.pjatk.jazapp.jpa;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.Optional;

@Named
@RequestScoped
public class addCategoryController {
    @Inject
    private SectionRepository sectionRepository;

    @Inject
    private CategoryRepository categoryRepository;

    @Inject
    private ParamRetriever paramRetriever;

    private EditCategoryRequest editCategoryRequest;

    public EditCategoryRequest getEditRequest() {
        if (editCategoryRequest == null) {
            editCategoryRequest = createEditCategoryRequest();
        }
        return editCategoryRequest;
    }

    public EditCategoryRequest getAddCategoryRequest(){
        if (editCategoryRequest == null) {
            editCategoryRequest = new EditCategoryRequest();
        }
        return editCategoryRequest;
    }

    private EditCategoryRequest createEditCategoryRequest() {
        if (paramRetriever.contains("categoryId")) {
            var categoryId = paramRetriever.getLong("categoryId");
            var category = categoryRepository.findCategoryById(categoryId).orElseThrow();
            return new EditCategoryRequest(category);
        }
        return new EditCategoryRequest();
    }

    public String edit() {
        var category = editCategoryRequest.toCategory();
        SectionEntity section = sectionRepository.findSectionById(editCategoryRequest.getSectionId()).get();
        category.setSection(section);
        categoryRepository.save(category);

        return "showCategories.xhtml?faces-redirect=true";
    }

    public String add() {
        String name = editCategoryRequest.getName();
        Long sectionId = editCategoryRequest.getSectionId();
        var section = sectionRepository.findSectionById(sectionId).orElseThrow();

        if (categoryRepository.findCategoryByName(name).isEmpty()){
            categoryRepository.save(new CategoryEntity(section, name));
        }

        return "showCategories.xhtml?faces-redirect=true";
    }
}
