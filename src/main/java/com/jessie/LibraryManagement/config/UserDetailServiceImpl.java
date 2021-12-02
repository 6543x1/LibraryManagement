package com.jessie.LibraryManagement.config;


import com.jessie.LibraryManagement.entity.User;
import com.jessie.LibraryManagement.service.PermissionService;
import com.jessie.LibraryManagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserDetailServiceImpl implements UserDetailsService {
    @Autowired
    private UserService userService;


    //    @Autowired
//    private PasswordEncoder passwordEncoder;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userService.getUser(username);
        if (user == null) {
            return null;//后续方法会自动抛出异常
        }
        if (user.getStatus() <= 0) {
            return null;
        }
        //throw new UsernameNotFoundException("没找到用户");
        List<String> authorities = new ArrayList<>();//permission应当存到Redis中

//        String[] permissionArray = new String[authorities.size()];
//        List<String> permissionNames = new ArrayList<>();
//        authorities.forEach(x -> permissionNames.add(x));
//        permissionNames.toArray(permissionArray);
//        System.out.println(permissionNames);
        authorities.add(new SimpleGrantedAuthority("ROLE_" + user.getRole()));

//        UserDetails userDetails= new JwtUser(user.getUid(),user.getUsername(),user.getPassword(),permissionNames,true);
        UserDetails userDetails = org.springframework.security.core.userdetails.User.withUsername(user.getUsername()).password(user.getPassword()).authorities(permissionArray).build();
        return userDetails;
    }
}
