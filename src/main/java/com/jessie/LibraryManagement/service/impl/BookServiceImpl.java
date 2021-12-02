package com.jessie.LibraryManagement.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jessie.LibraryManagement.entity.Book;
import com.jessie.LibraryManagement.entity.BookVo;
import com.jessie.LibraryManagement.entity.Bookinfo;
import com.jessie.LibraryManagement.mapper.BookinfoMapper;
import com.jessie.LibraryManagement.service.BookService;
import com.jessie.LibraryManagement.mapper.BookMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author 16473
* @description 针对表【book】的数据库操作Service实现
* @createDate 2021-11-27 16:02:09
*/
@Service
public class BookServiceImpl extends ServiceImpl<BookMapper, Book>
    implements BookService{

    @Autowired
    BookMapper bookMapper;
    @Autowired
    BookinfoMapper bookinfoMapper;
    @Override
    public void newBookVo(BookVo bookVo) {
        Book book=Book.builder().ISBN(bookVo.getISBN())
                .bookName(bookVo.getBookName())
                .author(bookVo.getAuthor())
                .type(bookVo.getType())
                .build();
        Bookinfo bookinfo=Bookinfo.builder().position(bookVo.getPosition())
                .ISBN(bookVo.getISBN())
                .build();
        if(bookMapper.selectOneByISBN(bookVo.getISBN())==null) {
            bookMapper.insertAll(book);
        }
        bookinfoMapper.insertSelective(bookinfo);
    }
    @Override
    public void newBookInfo(Bookinfo bookinfo) {

        bookinfoMapper.insertSelective(bookinfo);
    }

    @Override
    public Book getOneBook(String ISBN){
        return bookMapper.selectOneByISBN(ISBN);
    }

    @Override
    public List<BookVo> searchByBookName(String name){
        return bookMapper.searchByBookName(name);
    }
}




