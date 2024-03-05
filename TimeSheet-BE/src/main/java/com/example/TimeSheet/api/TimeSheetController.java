package com.example.TimeSheet.api;

import com.example.TimeSheet.model.TimeSheet;
import com.example.TimeSheet.service.TimeSheetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequestMapping("api/v1/timesheet")
@RestController
public class TimeSheetController {
    private final TimeSheetService timeSheetService;

    @Autowired
    public TimeSheetController(TimeSheetService timeSheetService){
        this.timeSheetService = timeSheetService;
    }

    @PostMapping
    public void addTimeSheet(@RequestBody TimeSheet timeSheet){
        timeSheetService.addTimeSheet(timeSheet);
    }

    @GetMapping
    public List<TimeSheet> getAllTimeSheet(){
        return timeSheetService.getAllTimeSheet();
    }

    @GetMapping(path="{id}")
    public TimeSheet getTimeSheetById(@PathVariable("id") int id){
        return timeSheetService.getTimeSheetById(id).orElse(null);
    }

    @DeleteMapping(path="{id}")
    public void deleteTimeSheetById(@PathVariable("id") int id){
        timeSheetService.deleteTimeSheet(id);
    }

    @PutMapping(path="{id}")
    public void updateTimeSheet(@PathVariable("id") int id, @RequestBody TimeSheet TimeSheetToUpdate){
        timeSheetService.updateTimeSheet(id, TimeSheetToUpdate);
    }
}
