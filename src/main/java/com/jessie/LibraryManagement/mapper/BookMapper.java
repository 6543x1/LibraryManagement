package com.jessie.LibraryManagement.mapper;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.jessie.LibraryManagement.entity.Book;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
* @author 16473
* @description 针对表【book】的数据库操作Mapper
* @createDate 2021-11-27 16:02:09
* @Entity com.jessie.LibraryManagement.entity.Book
*/
@Mapper
public interface BookMapper extends BaseMapper<Book> {
    int insertAll(Book book);

    List<Book> searchAllByBookName(@Param("bookName") String bookName);

    Book selectOneByISBN(int ISBN);
}




