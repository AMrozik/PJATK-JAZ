package pl.edu.pjatk.jazzapp.webapp;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@RequestScoped
public class RegisterRequest {
    @Inject
    private DB db;

    private String registerMsg;


    private String name;
    private String lastname;
    private String birth;
    private String username;
    private String email;
    private String password;

    public void setRegisterMsg(String registerMsg) {
        this.registerMsg = registerMsg;
    }

    public String getRegisterMsg() {
        return registerMsg;
    }

    public String getBirth() {
        return birth;
    }

    public String getEmail() {
        return email;
    }

    public String getLastname() {
        return lastname;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String register(){
        if (!db.userExists(username)){
            db.addUser(username, password);
            registerMsg = "Twoje konto zostało poprawnie założone, przejdź do strony logowania";
        }
        else{
            registerMsg = "Użytkownik o podanej nazwie istnieje już w systemie";
        }
        return "/register.xhtml";
    }
}
