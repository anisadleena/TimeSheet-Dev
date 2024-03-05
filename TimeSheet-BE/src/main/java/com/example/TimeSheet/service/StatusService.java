package com.example.TimeSheet.service;

import com.example.TimeSheet.dao.StatusDao;
import com.example.TimeSheet.dao.timeSheetDao;
import com.example.TimeSheet.model.Status;
import com.example.TimeSheet.model.TimeSheet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class StatusService {

    private final StatusDao statusdao;

    @Autowired
    public StatusService(@Qualifier("fakeStatusDao") StatusDao statusdao){
        this.statusdao = statusdao;
    }
    public int addStatus(Status status){
        return statusdao.insertStatus(status);
    }

    public List<Status> getAllStatus(){
        System.out.println("siniii : " + statusdao.selectAllStatus());
        return statusdao.selectAllStatus();
    }

    public Optional<Status> getStatusById(Integer status_id){
        return statusdao.selectStatusById(status_id);
    }
}
