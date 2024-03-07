package com.example.TimeSheet.repository;

import com.example.TimeSheet.model.TimeSheet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TimesheetRepository extends JpaRepository<TimeSheet, String> {
}
