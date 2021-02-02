package fr.sorbonne.paris.nord.university.api.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="team")
public class TeamEntity  {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String slogan;

    public TeamEntity (){

    }
    public TeamEntity (Long id,String name, String slogan){
        this.id = id;
        this.name = name;
        this.slogan = slogan;

    }

    public TeamEntity (String name, String slogan){
        this.name = name;
        this.slogan = slogan;

    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSlogan() {
        return slogan;
    }

    public void setSlogan(String slogan) {
        this.slogan = slogan;
    }


    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
