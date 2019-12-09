package pl.edu.pjatk.jazapp.login;

import pl.edu.pjatk.jazapp.auth.ProfileRepository;

import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;


@Named
@RequestScoped
public class LoginControler {

    @Inject
    private ProfileRepository db;

    @Inject
    private LoginRequest loginRequest;

    private String loginMsg;

    public void setLoginMsg(String loginMsg) {
        this.loginMsg = loginMsg;
    }

    public String getLoginMsg() {
        return loginMsg;
    }

    public String login() {
        String username = loginRequest.getUsername();
        String password = loginRequest.getPassword();

        if (db.correctCredentials(username, password)) {
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("user", username);
            return "index?faces-redirect=true";
        } else {
            loginMsg = "Niewłaściwy login lub hasło";
            return "";
        }
    }

    public String logout() {
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        return "index?faces-redirect=true";
    }
}
