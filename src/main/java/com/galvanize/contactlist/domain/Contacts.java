package com.galvanize.contactlist.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Data
@Entity
public class Contacts {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String givenName;
    private String surname;
    private String phoneNumber;

    public Contacts()
    {

    }

    public Contacts(String givenName, String surname, String phoneNumber) {
        this.givenName = givenName;
        this.surname = surname;
        this.phoneNumber = phoneNumber;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getGivenName() {
        return givenName;
    }

    public void setGivenName(String givenName) {
        this.givenName = givenName;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
