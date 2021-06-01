package com.cashfree.springboot.courseapp.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private String description;

    public Course(Long id, String title, String description) {      //needed till the time we don't have a database
        this.id = id;
        this.title = title;
        this.description = description;
    }


    protected Course() {        //default constructor as required by jpa
    }

    public Course(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }


    public String getTitle() {
        return this.title;
    }

    public String getDescription() {
        return this.description;
    }


    @Override
    public String toString() {      //toString method determines the json representation of response etc
        return "{" +
            " id='" + getId() + "'" +
            ", title='" + getTitle() + "'" +
            ", description='" + getDescription() + "'" +
            "}";
    }
    
   
}

 