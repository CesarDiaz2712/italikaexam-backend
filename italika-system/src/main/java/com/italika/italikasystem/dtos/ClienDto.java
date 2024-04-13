package com.italika.italikasystem.dtos;

import lombok.Builder;

@Builder
public class ClienDto {
    private Long id;
    private String name;
    private String lastname;
    private String surname;
    private String phoneNumber;
    private String email;
    
    public ClienDto(Long id, String name, String lastname, String surname, String phoneNumber, String email) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.surname = surname;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

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

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    
}
