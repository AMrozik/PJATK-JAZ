package pl.edu.pjatk.jazapp.auth;

public class User {
    private final String firstName;
    private final String lastName;
    private final String username;
    private final String password;
    private final String email;
    private final String  birthDate;
    private final boolean admin;

    public User(String firstName, String lastName, String username, String password, String email, String birthDate, boolean admin) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
        this.email = email;
        this.birthDate = birthDate;
        this.admin = admin;
    }

    public boolean isAdmin() {
        return admin;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public String getBirthDate() {
        return birthDate;
    }
}
