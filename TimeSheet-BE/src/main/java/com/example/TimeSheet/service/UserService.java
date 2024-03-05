package com.example.TimeSheet.service;

import com.example.TimeSheet.dao.StatusDao;
import com.example.TimeSheet.dao.UserDao;
import com.example.TimeSheet.model.Status;
import com.example.TimeSheet.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserDao userdao;

    @Autowired
    public UserService(@Qualifier("fakeUserDao") UserDao userdao){
        this.userdao = userdao;
    }
    public int addUser(User user){
        return userdao.insertUser(user);
    }

    public List<User> getAllUser(){
        return userdao.selectAllUser();
    }

    public Optional<User> getUserById(Integer user_id){
        return userdao.selectUserById(user_id);
    }
}
