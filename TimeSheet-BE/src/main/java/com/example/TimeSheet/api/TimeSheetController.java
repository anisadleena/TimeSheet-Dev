package com.example.TimeSheet.api;
import com.example.TimeSheet.model.Status;
import com.example.TimeSheet.model.TimeSheet;
import com.example.TimeSheet.service.TimeSheetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import java.util.List;
import java.util.Optional;

@RequestMapping("api/v1/timesheet")
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class TimeSheetController {

    @Autowired
    TimeSheetService timeSheetService;


    @GetMapping("/get/All")
    public ResponseEntity<List<TimeSheet>> getAllTimesheet(){
        List<TimeSheet> timesheet = timeSheetService.getAllTimesheet();
        return ResponseEntity.ok(timesheet);
    }

    @GetMapping("/get/{Id}")
    public ResponseEntity<Optional<TimeSheet>> getAllTimesheetByID(@PathVariable("Id") String id){
        Optional<TimeSheet> timesheet = timeSheetService.getAllTimesheetByID(id);
        return ResponseEntity.ok(timesheet);
    }

    @PostMapping("/create")
    public ResponseEntity<TimeSheet> createTimeSheet(@RequestBody TimeSheet timeSheet){
        TimeSheet createdTimeSheet = timeSheetService.createTimeSheet(timeSheet);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdTimeSheet);
    }

    @DeleteMapping("/delete/{Id}")
    public ResponseEntity<Optional<TimeSheet>> deleteTimeSheetById(@PathVariable("Id") String id){
        Optional<TimeSheet> timesheet = timeSheetService.deleteTimeSheetById(id);
        return ResponseEntity.ok(timesheet);
    }

    @PutMapping("/update/{Id}")
    public ResponseEntity<TimeSheet> updateTimeSheet(@PathVariable("Id") String id, @RequestBody TimeSheet TimeSheetToUpdate){
        Optional<TimeSheet> updatedTimeSheetOptional = timeSheetService.updateTimeSheet(id, TimeSheetToUpdate);

        if (updatedTimeSheetOptional.isPresent()) {
            TimeSheet updatedTimeSheet = updatedTimeSheetOptional.get();
            return ResponseEntity.status(HttpStatus.CREATED).body(updatedTimeSheet);
        } else {
            // Handle the case where the TimeSheet with the given id is not found
            return ResponseEntity.notFound().build();
        }
    }

}
