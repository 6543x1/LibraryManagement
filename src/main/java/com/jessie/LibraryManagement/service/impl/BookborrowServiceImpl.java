package com.jessie.LibraryManagement.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jessie.LibraryManagement.entity.BookBorrowVo;
import com.jessie.LibraryManagement.entity.Bookborrow;
import com.jessie.LibraryManagement.service.BookborrowService;
import com.jessie.LibraryManagement.mapper.BookborrowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author 16473
* @description 针对表【bookborrow】的数据库操作Service实现
* @createDate 2021-11-27 15:58:30
*/
@Service
public class BookborrowServiceImpl extends ServiceImpl<BookborrowMapper, Bookborrow>
    implements BookborrowService{

    @Autowired
    BookborrowMapper bookborrowMapper;
    @Override
    public void newBookBorrow(Bookborrow bookborrow){
        bookborrowMapper.insertAll(bookborrow);
    }
    @Override
    public List<Bookborrow> getReaderBorrow(int uid){
        return bookborrowMapper.selectAllByBookBorrower(uid);
    }
    @Override
    public void finishBorrow(int bookID, int uid){
        bookborrowMapper.finishBorrow(bookID,uid);
    }

    @Override
    public List<BookBorrowVo> notFinishedBorrowed(int uid){
        return bookborrowMapper.notFinishedBorrowed(uid);
    }
    @Override
    public List<BookBorrowVo> finishedBorrow(int uid){
        return bookborrowMapper.Borrowed(uid);
    }
}




