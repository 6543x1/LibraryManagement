package com.jessie.LibraryManagement.controller;

import com.jessie.LibraryManagement.entity.Result;
import com.jessie.LibraryManagement.entity.User;
import com.jessie.LibraryManagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class UserController
{
    @Autowired
    UserService userService;
    @PostMapping(value = "/register")
    public Result registerReader(User user){
        userService.newReader(user);
        return Result.success("注册成功");
    }
}
