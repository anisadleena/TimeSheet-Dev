package com.example.TimeSheet.dao;

import com.example.TimeSheet.model.Status;
import com.example.TimeSheet.model.TimeSheet;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("fakeStatusDao")
public class FakeStatusDataAccessService implements StatusDao{
    private static List<Status> DB = new ArrayList<>();

    @Override
    public int insertStatus(Integer id, Status status){
        DB.add(new Status(id, status.getStatus()));
        return 1;
    }

    @Override
    public List<Status> selectAllStatus(){
        return DB;
    }

    @Override
    public Optional<Status> selectStatusById(Integer id){
        return DB.stream().filter(status -> status.getStatusId().equals(id)).findFirst();
    }

}
