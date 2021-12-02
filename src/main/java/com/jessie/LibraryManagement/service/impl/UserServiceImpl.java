package com.jessie.LibraryManagement.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jessie.LibraryManagement.entity.JwtUser;
import com.jessie.LibraryManagement.entity.SimpleGrantedAuthority;
import com.jessie.LibraryManagement.entity.User;
import com.jessie.LibraryManagement.entity.myEnum.Role;
import com.jessie.LibraryManagement.service.UserService;
import com.jessie.LibraryManagement.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
* @author 16473
* @description 针对表【user】的数据库操作Service实现
* @createDate 2021-11-27 15:44:37
*/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserDetailsService,UserService {
    @Autowired
    UserMapper userMapper;
    static BCryptPasswordEncoder bCryptPasswordEncoder=new BCryptPasswordEncoder();

    @Override
    public void newReader(User user)
    {
        user.setUid(0);
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
            user.setRole(Role.reader);
        userMapper.insertSelective(user);
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
    public static int getCurrentUid()
    {
        int uid;
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Object principal = authentication.getPrincipal();
        if (principal == null)
        {
            return -1;
        }
        if (principal instanceof UserDetails)
        {
            JwtUser userDetails = (JwtUser) principal;
            uid=userDetails.getId();
        } else
        {
            uid=-1;
        }
        return uid;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userMapper.selectOneByUsername(username);
        if (user == null) {
            return null;//后续方法会自动抛出异常
        }
        if (user.getStatus() <= 0) {
            return null;
        }
        JwtUser jwtUser=new JwtUser(user.getUid(),user.getUsername(),user.getPassword(),true);
        Set<GrantedAuthority> roles = new HashSet<>();
        roles.add(new SimpleGrantedAuthority(user.getRole().toString()));
        jwtUser.setAuthorities(roles);
//        UserDetails userDetails = org.springframework.security.core.userdetails.User.withUsername(user.getUsername()).password(user.getPassword()).authorities(permissionArray).build();
        return jwtUser;
    }
//    public static int getCurrentUid(){
//        if(getCurrentUsername()==null){
//            return -1;
//        }
//        else{
////            return userMapper.getCurrentUid;
//        }
//    }
}




