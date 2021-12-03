package com.jessie.LibraryManagement.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.*;

import java.time.LocalDateTime;

@Data
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Builder
//Builder必须和All搭配使用，否则单独Builder和NoArgs会冲突
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
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime borrowTime;

    private String bookName;
    private String ISBN;
    private String position;
    private boolean finished;
    private String author;
    private String type;

}
