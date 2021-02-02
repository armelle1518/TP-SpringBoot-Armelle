package fr.sorbonne.paris.nord.university.api.controller;

import fr.sorbonne.paris.nord.university.api.entity.TeamEntity;

import javax.persistence.Id;

public class TeamDto {


    private Long id;
    private String name;
    private String slogan;

    public TeamDto (){

    }

    public TeamDto (Long id,String name, String slogan){
        this.id = id;
        this.name = name;
        this.slogan = slogan;

    }
    public TeamDto (String name, String slogan){

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


}
