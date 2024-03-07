//package com.example.TimeSheet.dao;
//
//import com.example.TimeSheet.model.Status;
//import com.example.TimeSheet.model.User;
//import org.springframework.stereotype.Repository;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//
//@Repository("fakeUserDao")
//public class FakeUserDataAccessService implements UserDao{
//    private static List<User> DB = new ArrayList<>();
//
//    @Override
//    public int insertUser(Integer user_id, User user){
//        DB.add(new User(user_id, user.getUsername(), user.getEmail()));
//        return 1;
//    }
//
//    @Override
//    public List<User> selectAllUser(){
//        return DB;
//    }
//
//    @Override
//    public Optional<User> selectUserById(Integer user_id){
//        return DB.stream().filter(user -> user.getUserId().equals(user_id)).findFirst();
//    }
//
//}
