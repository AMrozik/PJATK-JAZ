package pl.edu.pjatk.jazapp.jpa;

public class EditCategoryRequest {

    private Long id;
    private String name;
    private SectionEntity section;
    private Long sectionId;


    public EditCategoryRequest(CategoryEntity category) {
        this.name = category.getName();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public SectionEntity getSection() {
        return section;
    }

    public void setSection(SectionEntity section) {
        this.section = section;
    }

    public EditCategoryRequest(String name) {
        this.name = name;
    }

    public EditCategoryRequest() {
    }

    public CategoryEntity toCategory(){
        return new CategoryEntity(id, section, name);
    }

    public Long getSectionId() {
        return sectionId;
    }

    public void setSectionId(Long sectionId) {
        this.sectionId = sectionId;
    }
}
