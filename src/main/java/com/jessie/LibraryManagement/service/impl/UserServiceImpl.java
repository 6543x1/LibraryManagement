package com.jessie.LibraryManagement.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jessie.LibraryManagement.entity.User;
import com.jessie.LibraryManagement.entity.myEnum.Role;
import com.jessie.LibraryManagement.service.UserService;
import com.jessie.LibraryManagement.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

/**
* @author 16473
* @description 针对表【user】的数据库操作Service实现
* @createDate 2021-11-27 15:44:37
*/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
    implements UserService{
    @Autowired
    UserMapper userMapper;
    static BCryptPasswordEncoder bCryptPasswordEncoder=new BCryptPasswordEncoder();
    @Override
    public void newReader(User user)
    {

        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        if(user.getRole()== Role.admin){
            user.setRole(Role.reader);
        }
    }

    @Override
    public User getUser(String username)
    {
        return userMapper.selectOneByUsername(username);
    }
    //Spring Security获取当前会话的用户信息
    public static String getCurrentUsername()
    {
        String username;
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Object principal = authentication.getPrincipal();
        if (principal == null)
        {
            return null;
        }
        if (principal instanceof UserDetails)
        {
            UserDetails userDetails = (UserDetails) principal;
            username = userDetails.getUsername();
        } else
        {
            username = principal.toString();
        }
        return username;
    }

    public static int getCurrentUid(){
        if(getCurrentUsername()==null){
            return -1;
        }
        else{
            return userMapper.getCurrentUid;
        }
    }
}




