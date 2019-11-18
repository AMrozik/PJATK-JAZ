package pl.edu.pjatk.jazzapp.webapp;

import org.hibernate.jpa.boot.spi.EntityManagerFactoryBuilder;

import javax.persistence.*;

@Entity
public class ProfileEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String password;

    public ProfileEntity(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public ProfileEntity( ){};

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
