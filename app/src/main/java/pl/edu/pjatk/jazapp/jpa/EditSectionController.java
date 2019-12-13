package pl.edu.pjatk.jazapp.jpa;

import javax.enterprise.context.RequestScoped;
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

    public String save() {
        var section = editSectionRequest.toSection();
        sectionRepository.save(section);

        return "sectionView.xhtml?faces-redirect=true";
    }
}
