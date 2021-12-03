package com.jessie.LibraryManagement.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;

import lombok.*;

/**
 * 
 * @TableName bookborrow
 */
@TableName(value ="bookborrow")
@Data
@EqualsAndHashCode
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Bookborrow implements Serializable {

    @TableId(value = "borrowID",type = IdType.AUTO)
    private int borrowID;
    /**
     * 
     */
    @TableField(value = "bookID")
    private int bookID;

    /**
     * 
     */
    @TableField(value = "bookBorrower")
    private int bookBorrower;

    /**
     * 
     */
    @TableField(value = "days")
    private int days;

    /**
     * 
     */
    @TableField(value = "borrowTime")
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime borrowTime;

    @TableField(value = "finished")
    private boolean finished;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;





    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", bookID=").append(bookID);
        sb.append(", bookBorrower=").append(bookBorrower);
        sb.append(", days=").append(days);
        sb.append(", borrowTime=").append(borrowTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}