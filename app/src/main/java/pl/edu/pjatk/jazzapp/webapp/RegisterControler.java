package pl.edu.pjatk.jazzapp.webapp;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@RequestScoped
public class RegisterControler {
    @Inject
    private DB db;
    @Inject
    private RegisterRequest register;

    private String registerMsg;

    public void setRegisterMsg(String registerMsg) {
        this.registerMsg = registerMsg;
    }

    public String getRegisterMsg() {
        return registerMsg;
    }

    public String register(){
        if (!db.userExists(register.getUsername())){
            db.addUser(register.getUsername(), register.getPassword());
            registerMsg = "Twoje konto zostało poprawnie założone, przejdź do strony logowania";
        }
        else{
            registerMsg = "Użytkownik o podanej nazwie istnieje już w systemie";
        }
        return "/register.xhtml";
    }
}
