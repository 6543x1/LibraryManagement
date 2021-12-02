package com.jessie.LibraryManagement.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jessie.LibraryManagement.entity.Book;
import com.jessie.LibraryManagement.service.BookService;
import com.jessie.LibraryManagement.mapper.BookMapper;
import org.springframework.stereotype.Service;

/**
* @author 16473
* @description 针对表【book】的数据库操作Service实现
* @createDate 2021-11-27 16:02:09
*/
@Service
public class BookServiceImpl extends ServiceImpl<BookMapper, Book>
    implements BookService{

}




