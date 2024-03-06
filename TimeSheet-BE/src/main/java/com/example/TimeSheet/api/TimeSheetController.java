package com.example.TimeSheet.api;
import com.example.TimeSheet.model.TimeSheet;
import com.example.TimeSheet.service.TimeSheetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RequestMapping("api/v1/timesheet")
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class TimeSheetController {
    private final TimeSheetService timeSheetService;

    @Autowired
    public TimeSheetController(TimeSheetService timeSheetService){
        this.timeSheetService = timeSheetService;
    }

    @PostMapping("/create")
    public void addTimeSheet(@RequestBody TimeSheet timeSheet){
        timeSheetService.addTimeSheet(timeSheet);
    }

    @GetMapping("/get")
    public List<TimeSheet> getAllTimeSheet(){
        return timeSheetService.getAllTimeSheet();
    }

    @GetMapping("/get/{Id}")
    public TimeSheet getTimeSheetById(@PathVariable("id") int id){
        return timeSheetService.getTimeSheetById(id).orElse(null);
    }

    @DeleteMapping("/delete/{Id}")
    public void deleteTimeSheetById(@PathVariable("id") int id){
        timeSheetService.deleteTimeSheet(id);
    }

    @PutMapping("/update/{Id}")
    public void updateTimeSheet(@PathVariable("id") int id, @RequestBody TimeSheet TimeSheetToUpdate){
        timeSheetService.updateTimeSheet(id, TimeSheetToUpdate);
    }
}
