package com.jessie.LibraryManagement.mapper;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.jessie.LibraryManagement.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
* @author 16473
* @description 针对表【user】的数据库操作Mapper
* @createDate 2021-11-27 15:44:37
* @Entity com.jessie.LibraryManagement.entity.User
*/
@Mapper
public interface UserMapper extends BaseMapper<User> {
    int insertAll(User user);

    int insertSelective(User user);

    User selectOneByUsername(@Param("username") String username);

    int selectUidByUsername(@Param("username") String username);
}




