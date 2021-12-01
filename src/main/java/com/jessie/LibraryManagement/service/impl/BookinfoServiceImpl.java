package com.jessie.LibraryManagement.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jessie.LibraryManagement.entity.Bookinfo;
import com.jessie.LibraryManagement.service.BookinfoService;
import com.jessie.LibraryManagement.mapper.BookinfoMapper;
import org.springframework.stereotype.Service;

/**
* @author 16473
* @description 针对表【bookinfo】的数据库操作Service实现
* @createDate 2021-11-27 15:46:56
*/
@Service
public class BookinfoServiceImpl extends ServiceImpl<BookinfoMapper, Bookinfo>
    implements BookinfoService{

}




