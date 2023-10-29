package com.aryan.hackathon.StrartUps.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity(name = "founder")
public class Founder {

    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column
    private String name ;

    @Column
    private String startup_name;

    @Column
    private String sector;

    @Id
    @Column
    private String email;

    @Column
    private String contact_number;

    @Column
    private String password;


    public Founder() {
    }

    public Founder(String name, String startup_name, String sector, String email, String contact_number, String password) {
        this.name = name;
        this.startup_name = startup_name;
        this.sector = sector;
        this.email = email;
        this.contact_number = contact_number;
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStartup_name() {
        return startup_name;
    }

    public void setStartup_name(String startup_name) {
        this.startup_name = startup_name;
    }

    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContact_number() {
        return contact_number;
    }

    public void setContact_number(String contact_number) {
        this.contact_number = contact_number;
    }



    @Override
    public String toString() {
        return "Founder{" +
                "name='" + name + '\'' +
                ", startup_name='" + startup_name + '\'' +
                ", sector='" + sector + '\'' +
                ", email='" + email + '\'' +
                ", contact_number='" + contact_number + '\'' +
                '}';
    }
}
