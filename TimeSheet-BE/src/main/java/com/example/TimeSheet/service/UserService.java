package com.example.TimeSheet.service;

import com.example.TimeSheet.model.TimeSheet;
import com.example.TimeSheet.model.User;
import com.example.TimeSheet.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public List<User> getAllUser(){
        List<User> userList = null;
        userList = userRepository.findAll();
        System.out.println("userList : " + userList);

        return userList;
    }
}
