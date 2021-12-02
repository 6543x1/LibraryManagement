package com.jessie.LibraryManagement.service;

import com.jessie.LibraryManagement.entity.Book;
import com.baomidou.mybatisplus.extension.service.IService;
import com.jessie.LibraryManagement.entity.BookVo;
import com.jessie.LibraryManagement.entity.Bookinfo;

import java.util.List;

/**
* @author 16473
* @description 针对表【book】的数据库操作Service
* @createDate 2021-11-27 16:02:09
*/
public interface BookService extends IService<Book> {
    void newBookVo(BookVo bookVo);

    void newBookInfo(Bookinfo bookinfo);

    Book getOneBook(String ISBN);

    List<BookVo> searchByBookName(String name);
}
