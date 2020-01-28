package pl.edu.pjatk.jazapp.jpa;

import pl.edu.pjatk.jazapp.auth.ProfileRepository;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpSession;
import java.util.List;

@Named
@RequestScoped
public class AuctionController {
    @Inject
    AuctionRepository auctionRepository;

    @Inject
    ProfileRepository profileRepository;

    public List<AuctionEntity> auctionlist() {
        return auctionRepository.findAll();
    }

    public List<AuctionEntity> userAuctionList(){
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        String user = (String) session.getAttribute("user");
        Long ownerId = profileRepository.getUserId(user);
        return auctionRepository.findByOwner(ownerId);
    }

}
