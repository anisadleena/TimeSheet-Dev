package com.example.TimeSheet.service;

import com.example.TimeSheet.model.TimeSheet;
import com.example.TimeSheet.repository.TimesheetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class TimeSheetService {
    @Autowired
    TimesheetRepository timesheetRepository;

    public List<TimeSheet> getAllTimesheet(){
        List<TimeSheet> timesheetList = null;
        timesheetList = timesheetRepository.findAll();
        System.out.println("statusList : " + timesheetList);

        return timesheetList;
    }

    public Optional<TimeSheet> getAllTimesheetByID(String id){
        Optional<TimeSheet> timesheetByID = null;
        timesheetByID = timesheetRepository.findById(id);
        System.out.println("statusList : " + timesheetByID);

        return timesheetByID;
    }

    public TimeSheet createTimeSheet(TimeSheet timeSheetBody){
        //==================================================================
        //Option 1 :set/get function for create new TimeSheet inside Service
        //==================================================================
        TimeSheet newTimeSheet = new TimeSheet();
        newTimeSheet.setUserId(timeSheetBody.getUserId());
        newTimeSheet.setStatusId(timeSheetBody.getStatusId());
        newTimeSheet.setTaskDescription(timeSheetBody.getTaskDescription());
        newTimeSheet.setStartDate(timeSheetBody.getStartDate());
        newTimeSheet.setEndDate(timeSheetBody.getEndDate());
        newTimeSheet.setProject(timeSheetBody.getProject());
        System.out.println("timeSheetBody.getProject(): " +timeSheetBody.getProject());
        System.out.println("new.getProject(): " +newTimeSheet.getUserId());

        try {
            newTimeSheet = timesheetRepository.save(newTimeSheet);
            System.out.println("TimeSheet created successfully: " + newTimeSheet);
        } catch (Exception e) {
            System.out.println("Failed to create TimeSheet");
            e.printStackTrace();
            throw e; // You may want to handle this exception according to your application's requirements
        }

        //==================================================================
        //Option 2 :set/get function for create new TimeSheet inside Model
        //==================================================================
        //newTimeSheet.createTimeSheet(timeSheetBody);
        //==================================================================

        System.out.println("newTimeSheet :: "+ newTimeSheet);
        timesheetRepository.save(newTimeSheet);
        return newTimeSheet;
    }

    public Optional<TimeSheet> deleteTimeSheetById(String id){
        Optional<TimeSheet> deletetimesheetByid = null;
        deletetimesheetByid = timesheetRepository.findById(id);
        timesheetRepository.delete(deletetimesheetByid.get());
        return deletetimesheetByid;
    }

    public Optional<TimeSheet> updateTimeSheet(String id, TimeSheet timeSheetUpdBody){
        Optional<TimeSheet> optionalTimeSheet = timesheetRepository.findById(id);

        TimeSheet existingTimeSheet = optionalTimeSheet.get();
        existingTimeSheet.setUserId(timeSheetUpdBody.getUserId());
        existingTimeSheet.setStatusId(timeSheetUpdBody.getStatusId());
        existingTimeSheet.setTaskDescription(timeSheetUpdBody.getTaskDescription());
        existingTimeSheet.setStartDate(timeSheetUpdBody.getStartDate());
        existingTimeSheet.setEndDate(timeSheetUpdBody.getEndDate());
        existingTimeSheet.setProject(timeSheetUpdBody.getProject());
        System.out.println("timeSheetBody.getProject(): " +timeSheetUpdBody.getProject());
        System.out.println("new.getProject(): " +existingTimeSheet.getUserId());
        timesheetRepository.save(existingTimeSheet);

        return optionalTimeSheet;
    }
}