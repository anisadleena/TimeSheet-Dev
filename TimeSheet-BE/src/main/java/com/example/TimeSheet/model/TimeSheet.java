package com.example.TimeSheet.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name="timesheet")
public class TimeSheet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "timesheet_id")
    private int timesheet_id;

    @Column(name="user_id")
    private final int user_id;

    @Column(name="status_id")
    private final int status_id;

    @Column(name="task_description")
    private final String task_description;

    @Column(name="start_date")
    private final LocalDate start_date;

    @Column(name="end_date")
    private final LocalDate end_date;

    @Column(name="project")
    private final String project;

    public TimeSheet(
                     @JsonProperty("user_id") int user_id,
                     @JsonProperty("status_id") int status_id,
                     @JsonProperty("task_description") String task_description,
                     @JsonProperty("start_date") LocalDate date_from,
                     @JsonProperty("end_date") LocalDate date_to,
                     @JsonProperty("project") String project) {

        this.user_id = user_id;
        this.status_id = status_id;
        this.task_description = task_description;
        this.start_date = date_from;
        this.end_date = date_to;
        this.project = project;
    }

    public int getTimesheetId() {
        return timesheet_id;
    }

    public int getUserId() {
        return user_id;
    }

    public int getStatusId() {
        return status_id;
    }

    public String getTaskDescription() {
        return task_description;
    }

    public LocalDate getDateFrom() {
        return start_date;
    }

    public LocalDate getDateTo() {
        return end_date;
    }

    public String getProject() {
        return project;
    }
}
