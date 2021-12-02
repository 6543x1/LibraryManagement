package com.jessie.LibraryManagement.service;

import com.jessie.LibraryManagement.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author 16473
* @description 针对表【user】的数据库操作Service
* @createDate 2021-11-27 15:44:37
*/
public interface UserService extends IService<User> {
    void newReader(User user);
    User getUser(String username);
}
