package com.jessie.LibraryManagement.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BookVo {
    private String ISBN;

    /**
     *
     */
    private String bookName;


    /**
     *
     */
    private String author;

    /**
     *
     */
    private String type;

    private String position;

    private String bookID;

    private boolean borrowed;
}
