package pl.edu.pjatk.jazapp.jpa;

import pl.edu.pjatk.jazapp.auth.ProfileEntity;
import pl.edu.pjatk.jazapp.auth.ProfileRepository;

import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Named
@RequestScoped
public class AddAuctionController {

    @Inject
    private CategoryRepository categoryRepository;

    @Inject
    private ParamRetriever paramRetriever;

    @Inject
    private AuctionRepository auctionRepository;

    @Inject
    private ProfileRepository profileRepository;

    private EditAuctionRequest editAuctionRequest;

    public EditAuctionRequest getAddAuctionRequest(){
        if(editAuctionRequest == null){
            editAuctionRequest = new EditAuctionRequest();
        }
        return editAuctionRequest;
    }

    public EditAuctionRequest getEditAuctionRequest(){
        if(editAuctionRequest == null){
            editAuctionRequest = createEditAuctionRequest();
        }
        return editAuctionRequest;
    }

    private EditAuctionRequest createEditAuctionRequest() {
        if(paramRetriever.contains("auctionId")){
            var auctionId = paramRetriever.getLong("auctionId");
            var auction = auctionRepository.findAuctionById(auctionId);
            return new EditAuctionRequest(auction);
        }
        return new EditAuctionRequest();
    }


    public String add() {

        CategoryEntity category = categoryRepository.findCategoryById(editAuctionRequest.getCategoryId()).orElseThrow();
        String title = editAuctionRequest.getTitle();
        String description = editAuctionRequest.getDescription();

        List<PhotoEntity> photos = new ArrayList<>();
        photos.add(new PhotoEntity(editAuctionRequest.getPhoto0()));

        if(!editAuctionRequest.getPhoto1().equals(""))
            photos.add(new PhotoEntity(editAuctionRequest.getPhoto1()));
        if(!editAuctionRequest.getPhoto2().equals(""))
            photos.add(new PhotoEntity(editAuctionRequest.getPhoto2()));
        if(!editAuctionRequest.getPhoto3().equals(""))
            photos.add(new PhotoEntity(editAuctionRequest.getPhoto3()));

        photos.get(0).setOrder_by(0);

        List<AuctionParameterEntity> parameters = new ArrayList<>();
        if(!editAuctionRequest.getParameter0().equals("") || !editAuctionRequest.getParamValue0().equals(""))
            parameters.add(new AuctionParameterEntity(new ParameterEntity(editAuctionRequest.getParameter0()), editAuctionRequest.getParamValue0()));
        if(!editAuctionRequest.getParameter1().equals("") || !editAuctionRequest.getParamValue1().equals(""))
            parameters.add(new AuctionParameterEntity(new ParameterEntity(editAuctionRequest.getParameter1()), editAuctionRequest.getParamValue1()));
        if(!editAuctionRequest.getParameter2().equals("") || !editAuctionRequest.getParamValue2().equals(""))
            parameters.add(new AuctionParameterEntity(new ParameterEntity(editAuctionRequest.getParameter2()), editAuctionRequest.getParamValue2()));
        if(!editAuctionRequest.getParameter3().equals("") || !editAuctionRequest.getParamValue3().equals(""))
            parameters.add(new AuctionParameterEntity(new ParameterEntity(editAuctionRequest.getParameter3()), editAuctionRequest.getParamValue3()));

        BigDecimal price = editAuctionRequest.getPrice();
        HttpSession Session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        String owner = (String) Session.getAttribute("user");
        Long ownerId = profileRepository.getUserId(owner);
        AuctionEntity auction = new AuctionEntity(category, title, description, photos, parameters, price, ownerId);

        auctionRepository.save(auction);

        return "showAuctions.xhtml?faces-redirect=true";
    }

    public String edit(){
        Long categoryId = getEditAuctionRequest().getCategoryId();
        HttpSession Session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        String owner = (String) Session.getAttribute("user");
        Long ownerId = profileRepository.getUserId(owner);
        List<PhotoEntity> photos = getEditAuctionRequest().getPhotos();
        String description = getEditAuctionRequest().getDescription();
        String title = getEditAuctionRequest().getTitle();
        BigDecimal price = getEditAuctionRequest().getPrice();
        CategoryEntity category = categoryRepository.findCategoryById(categoryId).orElseThrow();
        ProfileEntity profile = profileRepository.findUserById(ownerId).orElseThrow();

        AuctionEntity auction = new AuctionEntity(getEditAuctionRequest().getId(),
                getEditAuctionRequest().getCategory(), getAddAuctionRequest().getTitle(),
                getEditAuctionRequest().getDescription(), getEditAuctionRequest().getPhotos(),
                getEditAuctionRequest().getParams(), getEditAuctionRequest().getPrice(), getEditAuctionRequest().getOwner_id());

        auctionRepository.save(auction);

        return "showUserAuctions.xhtml?faces-redirect=true";
    }

    public AddAuctionController() {
    }
}