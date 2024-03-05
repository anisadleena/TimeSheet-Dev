package com.example.TimeSheet.api;

import com.example.TimeSheet.model.Status;
import com.example.TimeSheet.model.User;
import com.example.TimeSheet.service.StatusService;
import com.example.TimeSheet.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("api/v1/user")
@RestController
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }

    @PostMapping
    public void addUser(@RequestBody User user){
        userService.addUser(user);
    }

    @GetMapping
    public List<User> getAllUser(){
        return userService.getAllUser();
    }

    @GetMapping(path="{user_id}")
    public User getUserById(@PathVariable("user_id") Integer user_id){
        return userService.getUserById(user_id).orElse(null);
    }

}
