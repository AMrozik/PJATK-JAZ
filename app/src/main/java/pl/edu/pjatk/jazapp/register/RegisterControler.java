package pl.edu.pjatk.jazapp.register;

import pl.edu.pjatk.jazapp.auth.ProfileRepository;
import pl.edu.pjatk.jazapp.auth.User;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@RequestScoped
public class RegisterControler {
    @Inject
    private RegisterRequest register;
    @Inject
    ProfileRepository db;

    private String registerMsg;

    public void setRegisterMsg(String registerMsg) {
        this.registerMsg = registerMsg;
    }

    public String getRegisterMsg() {
        return registerMsg;
    }

    public String register(){
        User user = new User(register.getName(), register.getLastname(), register.getUsername(), register.getPassword(), register.getEmail(), register.getBirth());
        if (!db.userExists(user)){
            db.addUser(user);
            registerMsg = "Twoje konto zostało poprawnie założone, przejdź do strony logowania";
        }
        else{
            registerMsg = "Użytkownik o podanej nazwie istnieje już w systemie";
        }
        return "/register.xhtml";
    }
}
