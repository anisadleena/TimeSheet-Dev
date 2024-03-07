//package com.example.TimeSheet.dao;
//import com.example.TimeSheet.model.Status;
//import java.util.List;
//import java.util.Optional;
//
//public interface StatusDao {
//    int insertStatus(Integer status_id, Status status);
//    default int insertStatus(Status status){
//        Integer status_id = status.getStatusId();
//        return insertStatus(status_id,status);
//    }
//
//    List<Status> selectAllStatus();
//
//    Optional<Status> selectStatusById(Integer id);
//}
