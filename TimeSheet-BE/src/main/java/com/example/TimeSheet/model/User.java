package com.example.TimeSheet.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="user")
@Getter
@Setter
public class User {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="username")
    private String username;
    @Column(name="email")
    private String email;

//    public User(@JsonProperty("user_id") Integer user_id, @JsonProperty("username") String username, @JsonProperty("email") String email){
//        this.user_id = user_id;
//        this.username = username;
//        this.email = email;
//    }
//    public Integer getUserId(){
//        return user_id;
//    }
//
//    public String getUsername(){
//        return username;
//    }
//    public String getEmail(){
//        return email;
//    }
}
