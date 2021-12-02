package com.jessie.LibraryManagement.controller;

import com.jessie.LibraryManagement.entity.BookVo;
import com.jessie.LibraryManagement.entity.Bookborrow;
import com.jessie.LibraryManagement.entity.Result;
import com.jessie.LibraryManagement.service.BookService;
import com.jessie.LibraryManagement.service.BookborrowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

import static com.jessie.LibraryManagement.service.impl.UserServiceImpl.getCurrentUid;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    BookService bookService;
    @Autowired
    BookborrowService bookborrowService;

    @PreAuthorize("hasAuthority('admin')")
    @PostMapping(value = "/newBook")
    public Result newBook(BookVo bookVo){
        bookService.newBookVo(bookVo);
        return Result.success("成功加入新书!",getCurrentUid());
    }
    @PostMapping(value = "/searchBook",produces = "application/json;charset=UTF-8")
    public Result searchBook(String bookName){
       List<BookVo> list=bookService.searchByBookName(bookName);
        return Result.success("搜索成功!",list);
    }
    @PostMapping(value = "/borrowBook")
    public Result borrowBook(int bookID,@RequestParam(defaultValue = "7") int borrowDays){
        Bookborrow bookborrow=Bookborrow.builder().bookID(bookID).bookBorrower(getCurrentUid()).borrowTime(LocalDateTime.now()).days(borrowDays).build();
        bookborrowService.newBookBorrow(bookborrow);
        return Result.success("借书成功！请于"+borrowDays+"内归还");
    }

}
