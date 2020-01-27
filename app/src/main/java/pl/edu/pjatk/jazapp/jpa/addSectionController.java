package pl.edu.pjatk.jazapp.jpa;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@RequestScoped
public class addSectionController {
    @Inject
    private addSectionRequest addSectionRequest;
    @Inject
    private SectionRepository sectionRepository;

    public String addSection(){
        Section section = new Section(addSectionRequest.getName());
//        sectionRepository

        return "admin/sectionView.xhtml?faces-redirect=true";
    }
}
