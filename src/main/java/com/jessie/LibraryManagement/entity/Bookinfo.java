package com.jessie.LibraryManagement.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;

import lombok.*;

/**
 * 
 * @TableName bookinfo
 */
@TableName(value ="bookinfo")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Bookinfo implements Serializable {
    /**
     * 
     */
    @TableId(value = "bookID", type = IdType.AUTO)
    private int bookID;

    /**
     * 
     */
    @TableField(value = "position")
    private String position;

    /**
     * 
     */
    @TableField(value = "ISBN")
    private String ISBN;

    @TableField(value = "borrowed")
    private boolean borrowed;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;



    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", bookID=").append(bookID);
        sb.append(", position=").append(position);
        sb.append(", ISBN=").append(ISBN);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}