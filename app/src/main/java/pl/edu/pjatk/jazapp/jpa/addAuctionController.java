package pl.edu.pjatk.jazapp.jpa;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named
@RequestScoped
public class addAuctionController {

    public String save(){

        return "showAuctions.xhtml?faces-redirect=true";
    }


    public addAuctionController() {
    }
}
