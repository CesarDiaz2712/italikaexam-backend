package com.italika.italikasystem.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import lombok.NoArgsConstructor;

@Entity
@NamedQuery(name = "Client.findAll", query = "SELECT c FROM Client c")
@Table(name = "italika_client")
@NoArgsConstructor
public class Client extends AbstractPersistableCustom<Long>{
    
    @Column(name = "name", nullable = false, columnDefinition="varchar(45)")
    private String name;
    
    @Column(name= "lastname", nullable = false, columnDefinition="varchar(45)")
    private String lastname;

    @Column(name= "surname", nullable = false, columnDefinition="varchar(45)")
    private String surname;
    
    @Column(name= "phone_number", nullable = false, columnDefinition="varchar(11)")
    private String phoneNumber;
    
    @Column(name= "email", nullable = false, columnDefinition="varchar(255)", unique = true)
    private String email;

    private Client(Long id, String name, String lastname, String surname, String phoneNumber, String email) {
        setId(id);
        this.name = name;
        this.lastname = lastname;
        this.surname = surname;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    private Client( String name, String lastname, String surname, String phoneNumber, String email) {
        this.name = name;
        this.lastname = lastname;
        this.surname = surname;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }
    
    public Client instance(Long id, String name, String lastname, String surname, String phoneNumber, String email){
        return new Client(id, name, lastname, surname, phoneNumber, email);
    }

    
    public Client instance( String name, String lastname, String surname, String phoneNumber, String email){
        return new Client(name, lastname, surname, phoneNumber, email);
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
