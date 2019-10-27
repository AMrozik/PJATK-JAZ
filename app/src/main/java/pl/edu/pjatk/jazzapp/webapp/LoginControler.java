package pl.edu.pjatk.jazzapp.webapp;

import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;


@Named
@RequestScoped
public class LoginControler {
    @Inject
    private DB db;

    @Inject
    LoginRequest loginRequest;

    public String login() {
        String username = loginRequest.getUsername();
        String password = loginRequest.getPassword();
        if (db.correctCredentials(username, password)) {
            System.out.println("Zalogowano");
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("user", username);
            return "/index.xhtml";
        } else {
            System.out.println("Nie Zalogowano");
            return "/login.xhtml";
        }
    }

    public String logout() {
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        return "index?faces-redirect=true";
    }
}
