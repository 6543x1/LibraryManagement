package com.jessie.LibraryManagement.entity;

import com.baomidou.mybatisplus.annotation.TableField;

import java.time.LocalDateTime;

public class BookBorrowVo {
    private int borrowID;
    private int bookID;

    /**
     *
     */
    private int bookBorrower;

    /**
     *
     */
    private int days;

    /**
     *
     */
    private LocalDateTime borrowTime;
    private String bookName;
    private String ISBN;
    private String position;
    private boolean finished;

}
