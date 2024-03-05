package com.example.TimeSheet.api;

import com.example.TimeSheet.model.Status;
import com.example.TimeSheet.service.StatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequestMapping("api/v1/status")
@RestController
public class StatusController {
    private final StatusService statusService;

    @Autowired
    public StatusController(StatusService statusService){
        this.statusService = statusService;
    }

    @PostMapping
    public void addStatus(@RequestBody Status status){
        statusService.addStatus(status);
    }

    @GetMapping
    public List<Status> getAllStatus(){
        System.out.println("tubikk : " + statusService.getAllStatus());
        return statusService.getAllStatus();
    }

    @GetMapping(path="{status_id}")
    public Status getStatusById(@PathVariable("status_id") Integer status_id){
        return statusService.getStatusById(status_id).orElse(null);
    }

}
