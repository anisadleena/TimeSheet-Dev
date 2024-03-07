package com.example.TimeSheet.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import java.sql.Time;
import java.time.LocalDate;

@Entity
@Table(name="timesheet")
@Getter
@Setter
public class TimeSheet {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name ="uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id")
    private String id;

    @Column(name="user_id")
    private Integer userId;

    @Column(name="status_id")
    private Integer statusId;

    @Column(name="task_description")
    private String taskDescription;

    @Column(name="start_date")
    private LocalDate startDate;

    @Column(name="end_date")
    private LocalDate endDate;

    @Column(name="project")
    private String project;

    //==================================================================
    //Option 2 :set/get function for create new TimeSheet inside Model
    //==================================================================
    //public void createTimeSheet (TimeSheet timeSheetBody) {
    //   userId = timeSheetBody.getUserId();
    //   statusId = timeSheetBody.getStatusId();
    //   taskDescription = timeSheetBody.getTaskDescription();
    //   startDate = timeSheetBody.getStartDate();
    //   endDate = timeSheetBody.getEndDate();
    //   project = timeSheetBody.getProject();
    //}
    //==================================================================

}
