package com.example.TimeSheet.dao;

import com.example.TimeSheet.model.TimeSheet;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("fakeDao")
public class FakeTimeSheetDataAccessService implements timeSheetDao {
    private static List<TimeSheet> DB = new ArrayList<>();

    @Override
    public int insertTimeSheet(TimeSheet timeSheet){
        DB.add(timeSheet);
        return 1;
    }

    @Override
    public List<TimeSheet> selectAllTimeSheet(){
        return DB;
    }

    @Override
    public Optional<TimeSheet> selectTimeSheetById(int id) {
        return DB.stream()
                .filter(timeSheet -> String.valueOf(timeSheet.getTimesheetId()).equals(String.valueOf(id)))
                .findFirst();
    }

    @Override
    public int deleteTimeSheetById(int id){
        Optional<TimeSheet> timeSheetMaybe = selectTimeSheetById(id);
        if(timeSheetMaybe.isEmpty()){
            return 0;
        }
        DB.remove(timeSheetMaybe.get());
        return 1;
    }

    @Override
    public int updateTimeSheetById(int timesheet_id, TimeSheet update){
        return selectTimeSheetById(timesheet_id).map(timeSheet -> {
            int indexOfTimeSheetToUpdate = DB.indexOf(timeSheet);
            if(indexOfTimeSheetToUpdate >= 0){
                DB.set(indexOfTimeSheetToUpdate, update);
                return 1;
            }
            return 0;
        }).orElse(0);
    }
}

