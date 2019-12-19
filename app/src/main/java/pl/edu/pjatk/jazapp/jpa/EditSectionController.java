package pl.edu.pjatk.jazapp.jpa;

import javax.enterprise.context.RequestScoped;
import javax.faces.context.Flash;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@RequestScoped
public class EditSectionController {
    @Inject
    private SectionRepository sectionRepository;

    @Inject
    private ParamRetriever paramRetriever;

    private EditSectionRequest editSectionRequest;

    public EditSectionRequest getEditRequest() {
        if (editSectionRequest == null) {
            editSectionRequest = createEditSectionRequest();
        }
        return editSectionRequest;
    }

    private EditSectionRequest createEditSectionRequest() {
        if (paramRetriever.contains("sectionId")) {
            var sectionId = paramRetriever.getLong("sectionId");
            var section = sectionRepository.findSectionById(sectionId).orElseThrow();
            return new EditSectionRequest(section);
        }
        return new EditSectionRequest();
    }

    public String edit() {
        var section = editSectionRequest.toSection();
        sectionRepository.save(section);

        return "sectionView.xhtml?faces-redirect=true";
    }

    public String add() {

        String name = editSectionRequest.getName();

        if (sectionRepository.findSectionByName(name).isEmpty()){
            sectionRepository.save(new SectionEntity(name));
        }



        return "sectionView.xhtml?faces-redirect=true";
    }
}
