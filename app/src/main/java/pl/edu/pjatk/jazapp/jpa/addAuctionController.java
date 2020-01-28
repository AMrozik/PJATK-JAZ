package pl.edu.pjatk.jazapp.jpa;

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
public class addAuctionController {

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

    private EditAuctionRequest createEditAuctionRequest() {
        if(paramRetriever.contains("auctionId")){
            var auctionId = paramRetriever.getLong("auctionId");
            var auction = auctionRepository.findAuctionById(auctionId).orElseThrow();
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
        photos.add(new PhotoEntity(editAuctionRequest.getPhoto1()));
        photos.add(new PhotoEntity(editAuctionRequest.getPhoto2()));
        photos.add(new PhotoEntity(editAuctionRequest.getPhoto3()));

        photos.get(0).setOrder_by(0);


        List<AuctionParameterEntity> parameters = new ArrayList<>();
        parameters.add(new AuctionParameterEntity(new ParameterEntity(editAuctionRequest.getParameter0()), editAuctionRequest.getParamValue0()));
        parameters.add(new AuctionParameterEntity(new ParameterEntity(editAuctionRequest.getParameter1()), editAuctionRequest.getParamValue1()));
        parameters.add(new AuctionParameterEntity(new ParameterEntity(editAuctionRequest.getParameter2()), editAuctionRequest.getParamValue2()));
        parameters.add(new AuctionParameterEntity(new ParameterEntity(editAuctionRequest.getParameter3()), editAuctionRequest.getParamValue3()));

        BigDecimal price = editAuctionRequest.getPrice();

        HttpSession Session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);

        String owner = (String) Session.getAttribute("user");

        Long ownerId = profileRepository.getUserId(owner);

        AuctionEntity auction = new AuctionEntity(category, title, description, photos, parameters, price, ownerId);

        auctionRepository.save(auction);

        return "showAuctions.xhtml?faces-redirect=true";
    }


    public addAuctionController() {
    }

}
