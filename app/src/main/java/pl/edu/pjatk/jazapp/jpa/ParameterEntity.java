package pl.edu.pjatk.jazapp.jpa;

import javax.persistence.*;

@Entity
@Table(name = "parameter")
public class ParameterEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ParameterEntity() {
    }

    public ParameterEntity(String name) {
        this.name = name;
    }
}
