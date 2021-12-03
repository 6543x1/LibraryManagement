package com.jessie.LibraryManagement.service;

import com.jessie.LibraryManagement.entity.BookBorrowVo;
import com.jessie.LibraryManagement.entity.Bookborrow;
import com.baomidou.mybatisplus.extension.service.IService;
import com.jessie.LibraryManagement.exception.TooManyBooksException;

import java.util.List;

/**
* @author 16473
* @description 针对表【bookborrow】的数据库操作Service
* @createDate 2021-11-27 15:58:30
*/
public interface BookborrowService extends IService<Bookborrow> {

    void newBookBorrow(Bookborrow bookborrow);

    List<Bookborrow> getReaderBorrow(int uid);

    void finishBorrow(int bookID, int uid);

    void setBorrow(int bookID, int bookBorrower);

    List<BookBorrowVo> notFinishedBorrowed(int uid);

    List<BookBorrowVo> finishedBorrow(int uid);


    List<BookBorrowVo> allNotFinished();

    void returnByISBN(String ISBN) throws TooManyBooksException;
}
