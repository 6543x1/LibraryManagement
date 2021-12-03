package com.jessie.LibraryManagement.mapper;
import java.util.List;

import com.jessie.LibraryManagement.entity.BookBorrowVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.jessie.LibraryManagement.entity.Bookborrow;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

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

    @Update("update bookborrow set finished=true where bookID=#{bookID} and bookBorrower=#{uid}")
    void finishBorrow(int bookID,int uid);

    @Select("select * from bookborrow b join bookinfo b2 on b.bookID = b2.bookID join book b3 on b2.ISBN =b3.ISBN " +
            "where b.bookID in (select bookID from bookborrow b4 where b4.bookBorrower=#{uid} and b4.finished=true)")
    List<BookBorrowVo> Borrowed(int uid);

    @Select("select * from bookborrow b join bookinfo b2 on b.bookID = b2.bookID join book b3 on b2.ISBN =b3.ISBN " +
            "where b.bookID in (select bookID from bookborrow b4 where b4.bookBorrower=#{uid} and b4.finished=false)")
    List<BookBorrowVo> notFinishedBorrowed(int uid);

    @Select("select * from bookborrow b join bookinfo b2 on b.bookID = b2.bookID join book b3 on b2.ISBN =b3.ISBN " +
            "where b.bookID in (select bookID from bookborrow b4 where b4.finished=false)")
    List<BookBorrowVo> allNotFinishedBorrowed();

    List<Bookborrow> selectAllByBookBorrowerAndBookID(@Param("bookBorrower") int bookBorrower, @Param("bookID") int bookID);

    @Select("select b.*,b2.ISBN from bookborrow b join bookinfo b2 on b2.bookID = b.bookID where b.bookBorrower=#{bookBorrower} and b2.ISBN=#{ISBN} and b.finished=false")
    List<Bookborrow> selectAllByBookIDANDISBN(int bookBorrower,String ISBN);



}




