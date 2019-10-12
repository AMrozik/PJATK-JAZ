package pl.edu.pjatk.jazzapp.webapp;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named
@RequestScoped
public class LoginControler {

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

    public void login(){

    }
}
