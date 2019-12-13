package pl.edu.pjatk.jazapp.jpa;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named
@RequestScoped
public class EditSectionRequest {

    private Long id;
    private String name;

    public EditSectionRequest() {
    }

    public EditSectionRequest(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public EditSectionRequest(SectionEntity section) {
        this.id = section.getId();
        this.name = section.getName();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public SectionEntity toSection(){
        return new SectionEntity(id, name);
    }
}
