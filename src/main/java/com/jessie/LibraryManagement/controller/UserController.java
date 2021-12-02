package com.jessie.LibraryManagement.controller;

import com.jessie.LibraryManagement.entity.Result;
import com.jessie.LibraryManagement.entity.User;
import com.jessie.LibraryManagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.jessie.LibraryManagement.service.impl.UserServiceImpl.getCurrentUid;

@RestController
@RequestMapping("/user")
public class UserController
{
    @Autowired
    UserService userService;
    @PostMapping(value = "/register")
    public Result registerReader(User user){
        if(user.getUsername()==null||user.getPassword()==null||user.getRealName()==null){
            return Result.error("信息填写不全！");
        }
        userService.newReader(user);
        return Result.success("注册成功");
    }

    @PreAuthorize("hasAuthority('admin')")
    @PostMapping(value = "/testResult")
    public Result testRole(){
        return Result.success("success!",getCurrentUid());
    }
}
