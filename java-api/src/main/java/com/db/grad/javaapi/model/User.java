package com.db.grad.javaapi.model;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {
    @Id
    private int id;
    private String username;

    public User() {
    }

    public User(String username, String password, String email, String role) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.role = role;
    }

    private String password;
    private String email;
    private String role;

//    @OneToMany(mappedBy = "User", targetEntity = BookUser.class, fetch = FetchType.EAGER)
//    private Set<BookUser> bookUserSet;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
