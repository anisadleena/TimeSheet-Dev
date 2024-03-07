package com.example.TimeSheet.api;

import com.example.TimeSheet.model.Status;
import com.example.TimeSheet.service.StatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

@RequestMapping("api/v1/status")
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class StatusController {

    @Autowired
    StatusService statusService;

    @GetMapping("/get/All")
    public ResponseEntity<List<Status>> getAllStatus(){
        List<Status> status = statusService.getAllStatus();
        return ResponseEntity.ok(status);
    }

}
