package pl.edu.pjatk.jazapp.jpa;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

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

    private EditCategoryRequest createEditCategoryRequest() {
        if (paramRetriever.contains("sectionId")) {
            var categoryId = paramRetriever.getLong("categoryId");
            var category = categoryRepository.findCategoryById(categoryId).orElseThrow();
            return new EditCategoryRequest(category);
        }
        return new EditCategoryRequest();
    }

    public String edit() {
        var category = editCategoryRequest.toCategory();
        categoryRepository.save(category);

        return "sectionView.xhtml?faces-redirect=true";
    }

    public String add() {

        String name = editCategoryRequest.getName();
        SectionEntity section = editCategoryRequest.getSection();

        if (categoryRepository.findCategoryByName(name).isEmpty()){
            categoryRepository.save(new CategoryEntity(section, name));
        }



        return "sectionView.xhtml?faces-redirect=true";
    }
}
