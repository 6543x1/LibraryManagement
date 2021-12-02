package com.jessie.LibraryManagement.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jessie.LibraryManagement.entity.Bookborrow;
import com.jessie.LibraryManagement.service.BookborrowService;
import com.jessie.LibraryManagement.mapper.BookborrowMapper;
import org.springframework.stereotype.Service;

/**
* @author 16473
* @description 针对表【bookborrow】的数据库操作Service实现
* @createDate 2021-11-27 15:58:30
*/
@Service
public class BookborrowServiceImpl extends ServiceImpl<BookborrowMapper, Bookborrow>
    implements BookborrowService{

}




