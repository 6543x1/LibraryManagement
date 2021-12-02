package com.jessie.LibraryManagement.mapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.jessie.LibraryManagement.entity.Bookinfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
* @author 16473
* @description 针对表【bookinfo】的数据库操作Mapper
* @createDate 2021-11-27 15:46:56
* @Entity com.jessie.LibraryManagement.entity.Bookinfo
*/
@Mapper
public interface BookinfoMapper extends BaseMapper<Bookinfo> {
    int insertAll(Bookinfo bookinfo);

    int insertSelective(Bookinfo bookinfo);

}




