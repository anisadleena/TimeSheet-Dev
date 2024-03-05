package com.example.TimeSheet.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Table(name="status")
public class Status {

    @Id
    @Column(name="status_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private final Integer status_id;

    @Column(name="status_name")
    private final String status_name;

    public Status(@JsonProperty("status_id") Integer status_id, @JsonProperty("status") String status){
        this.status_id = status_id;
        this.status_name = status;
    }
    public Integer getStatusId(){
        return status_id;
    }

    public String getStatus(){
        return status_name;
    }
}
