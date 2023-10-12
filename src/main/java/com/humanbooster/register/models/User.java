package com.humanbooster.register.models;

import com.humanbooster.register.Interfaces.RegisterGroup;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;


import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "utilisateur")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    @NotBlank(message = "Veuillez saisir un nom", groups = {RegisterGroup.class})
    private String nom;

    @Column
    @NotBlank(message = "Veuillez saisir un prénom", groups = {RegisterGroup.class})
    private String prenom;
    @Column(unique = true)
    @NotBlank(message = "Veuillez saisir un email", groups = {RegisterGroup.class} )
    @Email(message = "Veuillez saisir un email valide", groups = {RegisterGroup.class})
    private String email;
    @Column
    private String password;

    @Transient
    private String confirmpassword;

    public User(String nom, String prenom, String email, String password, String confirmpassword) {
    this.roles = new ArrayList<Role>();
    }

    public User() {

    }

    public void addRole(Role role) {
        this.roles.add(role);
    }

    public void removeRole(Role role) {
        this.roles.remove(role);
    }


    @ManyToMany
    private List<Role> roles;

    public User(String nom, String prenom, String email, String password, String confirmpassword, List<Role> roles) {
        this.roles = new ArrayList<Role>();
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.password = password;
        this.confirmpassword = confirmpassword;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String nom) {
        this.nom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmpassword() {
        return confirmpassword;
    }

    public void setConfirmpassword(String confirmpassword) {
        this.confirmpassword = confirmpassword;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }


}
