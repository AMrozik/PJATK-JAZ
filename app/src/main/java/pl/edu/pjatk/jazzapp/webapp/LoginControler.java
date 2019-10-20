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

        private String password;
        private String username;


        public String getUsername() {
            return username;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public void setUsername(String username) {
            this.username = username;
        }

    public String login(){
        if(db.correctCredentials(username, password)){
            System.out.println("Zalogowano");
            FacesContext facesContext = FacesContext.getCurrentInstance();
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("user", username);
            return "/index.xhtml";
        }
        else{
            System.out.println("Nie Zalogowano");
            return "/login.xhtml";
        }
    }

    public String logout() {
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        return "index?faces-redirect=true";
    }
}
