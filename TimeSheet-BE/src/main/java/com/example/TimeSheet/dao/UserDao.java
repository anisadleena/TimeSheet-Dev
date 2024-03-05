package com.example.TimeSheet.dao;

import com.example.TimeSheet.model.User;

import java.util.List;
import java.util.Optional;

public interface UserDao {
    int insertUser(Integer user_id, User user);
    default int insertUser(User user){
        Integer user_id = user.getUserId();
        return insertUser(user_id,user);
    }

    List<User> selectAllUser();

    Optional<User> selectUserById(Integer user_id);
}
