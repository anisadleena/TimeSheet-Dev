package com.example.TimeSheet.service;

import com.example.TimeSheet.model.Status;
import com.example.TimeSheet.repository.StatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class StatusService {
    @Autowired
    StatusRepository statusRepository;

    public List<Status> getAllStatus(){
        List<Status> statusList = null;
        statusList = statusRepository.findAll();
        System.out.println("statusList : " + statusList);

        return statusList;
    }

}
