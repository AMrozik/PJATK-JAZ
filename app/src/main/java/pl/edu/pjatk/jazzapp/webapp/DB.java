package pl.edu.pjatk.jazzapp.webapp;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import java.util.HashMap;

@Named
@ApplicationScoped
public class DB {
    private HashMap<String, String> map;
    public DB(){
        map = new HashMap<>();
        map.put("Ziggy", "123");
        map.put("root", "toor");
    }

    public void addUser(String username, String password){
        map.put(username, password);
    }

    public boolean userExists(String username){
        return map.containsKey(username);
    }

    public boolean correctCredentials(String username, String password){
        return map.containsKey(username) && map.get(username).equals(password);
    }
}
