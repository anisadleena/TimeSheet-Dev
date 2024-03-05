package com.example.TimeSheet.dao;

import com.example.TimeSheet.model.TimeSheet;

import java.util.List;
import java.util.Optional;

public interface timeSheetDao {
    int insertTimeSheet(TimeSheet timeSheet);
    List<TimeSheet> selectAllTimeSheet();
    Optional<TimeSheet> selectTimeSheetById(int id);
    int deleteTimeSheetById(int id);
    int updateTimeSheetById(int id, TimeSheet timeSheet);
}
