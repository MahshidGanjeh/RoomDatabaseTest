package com.yaratech.roomtest.data.table;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;

import static android.arch.persistence.room.ForeignKey.CASCADE;

@Entity(tableName = "comment",
        foreignKeys = {@ForeignKey(entity = Post.class,
                parentColumns = "pid",
                childColumns = "postId",
                onDelete = CASCADE),
                @ForeignKey(entity = User.class, parentColumns = "uid",
                        childColumns = "userId", onDelete = CASCADE)})
public class Comment {

    @PrimaryKey(autoGenerate = true)
    private int cid;

    public Comment(int postId, int userId, String userName, String commentText) {
        this.postId = postId;
        this.userId = userId;
        this.userName = userName;
        this.commentText = commentText;
    }

    @ColumnInfo(name = "postId")
    public int postId;

    @ColumnInfo(name = "userId")
    public int userId;

    @ColumnInfo(name = "user_name")
    private String userName;

    @ColumnInfo(name = "comment_text")
    private String commentText;

    public Comment() {
    }

    public Comment(int postId, int userId) {
        this.postId = postId;
        this.userId = userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Comment(int postId) {
        this.postId = postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setCommentText(String commentText) {
        this.commentText = commentText;
    }

    public int getCid() {
        return cid;
    }

    public String getUserName() {
        return userName;
    }

    public String getCommentText() {
        return commentText;
    }
}
