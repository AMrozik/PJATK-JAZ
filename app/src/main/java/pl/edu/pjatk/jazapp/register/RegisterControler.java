package pl.edu.pjatk.jazapp.register;

import pl.edu.pjatk.jazapp.auth.DB;
import pl.edu.pjatk.jazapp.auth.ProfileRepository;
import pl.edu.pjatk.jazapp.auth.User;

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
    @Inject
    ProfileRepository pr;

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
            User user = new User(register.getName(), register.getLastname(), register.getUsername(), register.getPassword(), register.getEmail(), register.getBirth());
            pr.sampleCodeWithPC(user);
            registerMsg = "Twoje konto zostało poprawnie założone, przejdź do strony logowania";
        }
        else{
            registerMsg = "Użytkownik o podanej nazwie istnieje już w systemie";
        }
        return "/register.xhtml";
    }





////    TODO: zmienić hashmape na baze danych
//
//    @Inject
//    private RegisterRequest registerRequest;
//
//    @Inject
//    private ProfileService profileService;
//
//    public String register() {
//        if (profileService.doesUserExist(registerRequest.getUsername())) {
////            FacesContext.getCurrentInstance().getExternalContext().getFlash()
////                    .put("already-exists", "Username already exists.");
//            registerMsg = "user already exists";
//            return "";
//        }
//
//        profileService.addUser(
//                registerRequest.getName(),
//                registerRequest.getLastname(),
//                registerRequest.getUsername(),
//                registerRequest.getPassword(),
//                registerRequest.getEmail(),
//                registerRequest.getBirth()
//        );
//
//        return "login.xhtml?faces-redirect=true";
//    }
}
