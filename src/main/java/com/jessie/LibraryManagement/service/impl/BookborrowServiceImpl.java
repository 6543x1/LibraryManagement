package com.jessie.LibraryManagement.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jessie.LibraryManagement.entity.BookBorrowVo;
import com.jessie.LibraryManagement.entity.Bookborrow;
import com.jessie.LibraryManagement.entity.Bookinfo;
import com.jessie.LibraryManagement.exception.BookBorrowedException;
import com.jessie.LibraryManagement.exception.NotYourBookException;
import com.jessie.LibraryManagement.mapper.BookMapper;
import com.jessie.LibraryManagement.mapper.BookinfoMapper;
import com.jessie.LibraryManagement.service.BookborrowService;
import com.jessie.LibraryManagement.mapper.BookborrowMapper;
import org.redisson.RedissonLock;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.concurrent.TimeUnit;

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

    @Autowired
    BookinfoMapper bookinfoMapper;

    @Autowired
    RedissonClient redissonClient;
    @Override
    public void newBookBorrow(Bookborrow bookborrow) throws BookBorrowedException{
        RLock lock=redissonClient.getFairLock("Type:bookBorrow:bookID:"+bookborrow.getBookID());
        try{
            if(lock.tryLock(10,60, TimeUnit.SECONDS)){//-1才代表不业务超时释放锁
                realBookBorrow(bookborrow);

            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    @Transactional
    public void realBookBorrow(Bookborrow bookborrow) throws BookBorrowedException{
        if(bookinfoMapper.selectBorrowedByBookID(bookborrow.getBookID())){
            throw new BookBorrowedException();
        }
        else{
            bookborrowMapper.insertAll(bookborrow);
            bookinfoMapper.updateBorrowedByBookID(true,bookborrow.getBookID());
        }
    }
    @Override
    public List<Bookborrow> getReaderBorrow(int uid){
        return bookborrowMapper.selectAllByBookBorrower(uid);
    }
    @Override
    public void finishBorrow(int bookID, int uid) throws NotYourBookException{
        List<Bookborrow> bookborrows=bookborrowMapper.selectAllByBookBorrowerAndBookID(uid,bookID);
        if(bookborrows==null||bookborrows.size()!=1){
            throw new NotYourBookException();
        }
        bookborrowMapper.finishBorrow(bookID,uid);
        bookinfoMapper.updateBorrowedByBookID(false,bookID);
    }

    @Override
    @Transactional
    public void setBorrow(int bookID, int bookBorrower){
        bookborrowMapper.finishBorrow(bookID,bookBorrower);
        bookinfoMapper.updateBorrowedByBookID(false,bookID);
    }

    @Override
    public List<BookBorrowVo> notFinishedBorrowed(int uid){
        return bookborrowMapper.notFinishedBorrowed(uid);
    }
    @Override
    public List<BookBorrowVo> finishedBorrow(int uid){
        return bookborrowMapper.Borrowed(uid);
    }

    @Override
    public List<BookBorrowVo> allNotFinished(){
        return bookborrowMapper.allNotFinishedBorrowed();
    }
}




