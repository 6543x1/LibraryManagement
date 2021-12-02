package com.jessie.LibraryManagement.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 
 * @TableName bookinfo
 */
@TableName(value ="bookinfo")
@Data
public class Bookinfo implements Serializable {
    /**
     * 
     */
    @TableId(value = "bookID", type = IdType.AUTO)
    private Integer bookID;

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
        Bookinfo other = (Bookinfo) that;
        return (this.getBookID() == null ? other.getBookID() == null : this.getBookID().equals(other.getBookID()))
            && (this.getPosition() == null ? other.getPosition() == null : this.getPosition().equals(other.getPosition()))
            && (this.getISBN() == null ? other.getISBN() == null : this.getISBN().equals(other.getISBN()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getBookID() == null) ? 0 : getBookID().hashCode());
        result = prime * result + ((getPosition() == null) ? 0 : getPosition().hashCode());
        result = prime * result + ((getISBN() == null) ? 0 : getISBN().hashCode());
        return result;
    }

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