package com.jessie.LibraryManagement.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;

import lombok.*;

/**
 * 
 * @TableName book
 */
@TableName(value ="book")
@Data
@Builder
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class Book implements Serializable {
    /**
     * 
     */
    @TableId(value = "ISBN")
    private String ISBN;

    /**
     * 
     */
    @TableField(value = "bookName")
    private String bookName;



    /**
     * 
     */
    @TableField(value = "author")
    private String author;

    /**
     * 
     */
    @TableField(value = "type")
    private String type;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;





    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", ISBN=").append(ISBN);
        sb.append(", bookName=").append(bookName);
        sb.append(", author=").append(author);
        sb.append(", type=").append(type);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}