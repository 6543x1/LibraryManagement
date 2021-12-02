package com.jessie.LibraryManagement.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.Data;

/**
 * 
 * @TableName bookborrow
 */
@TableName(value ="bookborrow")
@Data
public class Bookborrow implements Serializable {
    /**
     * 
     */
    @TableField(value = "bookID")
    private Integer bookID;

    /**
     * 
     */
    @TableField(value = "bookBorrower")
    private Integer bookBorrower;

    /**
     * 
     */
    @TableField(value = "days")
    private Integer days;

    /**
     * 
     */
    @TableField(value = "borrowTime")
    private LocalDateTime borrowTime;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        Bookborrow other = (Bookborrow) that;
        return (this.getBookID() == null ? other.getBookID() == null : this.getBookID().equals(other.getBookID()))
            && (this.getBookBorrower() == null ? other.getBookBorrower() == null : this.getBookBorrower().equals(other.getBookBorrower()))
            && (this.getDays() == null ? other.getDays() == null : this.getDays().equals(other.getDays()))
            && (this.getBorrowTime() == null ? other.getBorrowTime() == null : this.getBorrowTime().equals(other.getBorrowTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getBookID() == null) ? 0 : getBookID().hashCode());
        result = prime * result + ((getBookBorrower() == null) ? 0 : getBookBorrower().hashCode());
        result = prime * result + ((getDays() == null) ? 0 : getDays().hashCode());
        result = prime * result + ((getBorrowTime() == null) ? 0 : getBorrowTime().hashCode());
        return result;
    }

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