package com.jessie.LibraryManagement.mapper;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.jessie.LibraryManagement.entity.Bookborrow;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
* @author 16473
* @description 针对表【bookborrow】的数据库操作Mapper
* @createDate 2021-11-27 15:58:30
* @Entity com.jessie.LibraryManagement.entity.Bookborrow
*/
@Mapper
public interface BookborrowMapper extends BaseMapper<Bookborrow> {
    int insertAll(Bookborrow bookborrow);

    List<Bookborrow> selectAllByBookBorrower(@Param("bookBorrower") Integer bookBorrower);

    List<Bookborrow> selectAllByBookID(@Param("bookID") Integer bookID);
}




