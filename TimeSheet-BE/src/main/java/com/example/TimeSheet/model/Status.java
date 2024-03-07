package com.example.TimeSheet.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name="status")
@Getter
@Setter
public class Status {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="status_name")
    private String statusName;

//    public Status(@JsonProperty("status_id") Integer status_id, @JsonProperty("statusName") String statusName){
//        this.id = id;
//        this.statusName = statusName;
//    }
//    public Integer getStatusId(){
//        return id;
//    }
//
//    public String getStatus(){
//        return statusName;
//    }
}
