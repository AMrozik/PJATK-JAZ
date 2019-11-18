package pl.edu.pjatk.jazapp.register;

import com.sun.xml.bind.v2.TODO;
import pl.edu.pjatk.jazapp.auth.ProfileService;

import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@RequestScoped
public class RegisterControler {
//    @Inject
//    private DB db;
//    @Inject
//    private RegisterRequest register;
//    @Inject
//    ProfileRepository pr;
//
    private String registerMsg;

    public void setRegisterMsg(String registerMsg) {
        this.registerMsg = registerMsg;
    }

    public String getRegisterMsg() {
        return registerMsg;
    }
//
//    public String register(){
//        if (!db.userExists(register.getUsername())){
//            db.addUser(register.getUsername(), register.getPassword());
//            pr.sampleCodeWithPC();
//            registerMsg = "Twoje konto zostało poprawnie założone, przejdź do strony logowania";
//        }
//        else{
//            registerMsg = "Użytkownik o podanej nazwie istnieje już w systemie";
//        }
//        return "/register.xhtml";
//    }





//    TODO: zmienić hashmape na baze danych

    @Inject
    private RegisterRequest registerRequest;

    @Inject
    private ProfileService profileService;

    public String register() {
        if (profileService.doesUserExist(registerRequest.getUsername())) {
            FacesContext.getCurrentInstance().getExternalContext().getFlash()
                    .put("already-exists", "Username already exists.");
            return "register.xhtml?faces-redirect=true";
        }

        profileService.addUser(
                registerRequest.getName(),
                registerRequest.getLastname(),
                registerRequest.getUsername(),
                registerRequest.getPassword(),
                registerRequest.getEmail(),
                registerRequest.getBirth()
        );

        return "login.xhtml?faces-redirect=true";
    }
}
