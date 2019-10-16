package pl.edu.pjatk.jazzapp.webapp;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Named
@RequestScoped
public class RegisterRequest {

    private String name;
    private String lastname;
    private String birth;
    private String username;
    private String email;
    private String password;

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

    public void register(){
        if(CheckDate(birth) && CheckEmail(email) && CheckName(name) && CheckName(lastname) && CheckPassword(password) && CheckUserName(username)){ // && username and email does not appear in database which doesn't exist
            //zapisz użytkownika do bazy której nie ma
            System.out.println("Pomyślnie utworzono użytkownika");
        }
    }


    public boolean CheckName(String name){
        String regex = "^[a-zA-Z0-9]{3,50}$";

        Pattern pattern = Pattern.compile(regex);

        Matcher matcher = pattern.matcher(name);
        return matcher.matches();
    }

    public boolean CheckEmail(String email) {
        String regex = "^[a-zA-Z0-9.!#$%&’*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\\.[a-zA-Z0-9-]+)*$";

        Pattern pattern = Pattern.compile(regex);

        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    public boolean CheckDate(String date) {
        String regex = "^[0-9]{2}/[0-9]{2}/[0-9]{4}$";

        Pattern pattern = Pattern.compile(regex);

        Matcher matcher = pattern.matcher(date);
        return matcher.matches();
    }

    public boolean CheckUserName(String date) {
        String regex = "^[a-z0-9]{3,50}$";

        Pattern pattern = Pattern.compile(regex);

        Matcher matcher = pattern.matcher(date);
        return matcher.matches();
    }

    public boolean CheckPassword(String date) {
        String regex = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{5,30}$";

        Pattern pattern = Pattern.compile(regex);

        Matcher matcher = pattern.matcher(date);
        return matcher.matches();
    }
}
