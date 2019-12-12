package pl.edu.pjatk.jazapp.jpa;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
@RequestScoped
public class SectionController {

    @Inject SectionRepository sectionRepository;

    public List<SectionEntity> sectionList(){
        return sectionRepository.findAll();
    }
}
