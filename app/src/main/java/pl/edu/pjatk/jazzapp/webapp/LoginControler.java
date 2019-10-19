package pl.edu.pjatk.jazzapp.webapp;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.registry.infomodel.User;
import java.io.IOException;

@Named
@RequestScoped
public class LoginControler extends HttpServlet {
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

    public void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(db.correctCredentials(username, password)){
            FacesContext context = FacesContext.getCurrentInstance();
            System.out.println("Zalogowano");
            context.getExternalContext().getSessionMap().put("user", username);
            resp.sendRedirect("/index.xhtml");
        }
        else{
            System.out.println("Nie Zalogowano");
        }
    }

//    @EJB
//    private UserService userService;
//
//    public String login() {
//        User user = userService.find(username, password);
//        FacesContext context = FacesContext.getCurrentInstance();
//
//        if (user == null) {
//            context.addMessage(null, new FacesMessage("Unknown login, try again"));
//            username = null;
//            password = null;
//            return null;
//        } else {
//            context.getExternalContext().getSessionMap().put("user", user);
//            return "userhome?faces-redirect=true";
//        }
//    }
//
//    public String logout() {
//        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
//        return "index?faces-redirect=true";
//    }
}
