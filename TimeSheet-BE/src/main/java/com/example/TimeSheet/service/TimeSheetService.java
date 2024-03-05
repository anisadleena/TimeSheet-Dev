package com.example.TimeSheet.service;

import com.example.TimeSheet.dao.timeSheetDao;
import com.example.TimeSheet.model.TimeSheet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class TimeSheetService {

    private final timeSheetDao timesheetdao;

    @Autowired
    public TimeSheetService(@Qualifier("fakeDao") timeSheetDao timesheetdao){
        this.timesheetdao = timesheetdao;
    }
    public int addTimeSheet(TimeSheet timeSheet){
        return timesheetdao.insertTimeSheet(timeSheet);
    }

    public List<TimeSheet> getAllTimeSheet(){
        return timesheetdao.selectAllTimeSheet();
    }

    public Optional<TimeSheet> getTimeSheetById(int id){
        return timesheetdao.selectTimeSheetById(id);
    }

    public int deleteTimeSheet(int id){
        return timesheetdao.deleteTimeSheetById(id);
    }

    public int updateTimeSheet(int id, TimeSheet newTimeSheet){
        return timesheetdao.updateTimeSheetById(id, newTimeSheet);
    }
}
