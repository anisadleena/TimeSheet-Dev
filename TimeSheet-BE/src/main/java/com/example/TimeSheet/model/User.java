package com.example.TimeSheet.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

@Entity
@Table(name="user")
public class User {

    @Id
    @Column(name="user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private final Integer user_id;

    @Column(name="username")
    private final String username;
    @Column(name="email")
    private final String email;

    public User(@JsonProperty("user_id") Integer user_id, @JsonProperty("username") String username, @JsonProperty("email") String email){
        this.user_id = user_id;
        this.username = username;
        this.email = email;
    }
    public Integer getUserId(){
        return user_id;
    }

    public String getUsername(){
        return username;
    }
    public String getEmail(){
        return email;
    }
}
