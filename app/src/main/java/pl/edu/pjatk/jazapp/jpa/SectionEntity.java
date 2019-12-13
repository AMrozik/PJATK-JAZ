package pl.edu.pjatk.jazapp.jpa;

import javax.persistence.*;

@Entity
@Table(name = "section")
public class SectionEntity {
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

    public SectionEntity(String name) {
        this.name = name;
    }

    public SectionEntity(){};

    public SectionEntity(Long id, String name){
        this.id = id;
        this.name = name;
    }

    public SectionEntity(Section section){
        this.name = section.getName();
    }
}
