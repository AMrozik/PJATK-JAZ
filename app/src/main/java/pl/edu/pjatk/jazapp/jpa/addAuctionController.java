package pl.edu.pjatk.jazapp.jpa;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@RequestScoped
public class addAuctionController {

    @Inject
    private CategoryRepository categoryRepository;

    @Inject
    private ParamRetriever paramRetriever;

    @Inject
    private AuctionRepository auctionRepository;

    private EditAuctionRequest editAuctionRequest;

    public EditAuctionRequest getEditAuctionRequest(){
        if(editAuctionRequest == null){
            editAuctionRequest = createEditAuctionRequest();
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


    public String save() {

        return "showAuctions.xhtml?faces-redirect=true";
    }


    public addAuctionController() {
    }
}
