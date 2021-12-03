package com.jessie.LibraryManagement.mapper;
import java.util.List;

import com.jessie.LibraryManagement.entity.BookVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.jessie.LibraryManagement.entity.Book;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;

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

    Book selectOneByISBN(String ISBN);

    @Select("select b.*,b2.bookID,b2.`position`,b2.borrowed from book b join bookinfo b2 on b.ISBN =b2.ISBN where match (b.bookName) against(#{bookName} IN natural language MODE)")
    List<BookVo> searchByBookName(String bookName);
    //直接加个是否借出属性吧，要不写这么长一串叠杀人书啊
    List<BookVo> searchByAuthor(@Param("author") String author);

    List<BookVo> searchByISBN(@Param("ISBN") String ISBN);


}




