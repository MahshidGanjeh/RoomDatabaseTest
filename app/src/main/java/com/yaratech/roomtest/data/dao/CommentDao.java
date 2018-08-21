package com.yaratech.roomtest.data.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.yaratech.roomtest.data.table.Comment;

import java.util.List;

@Dao
public interface CommentDao {

    @Insert
    public void insertComment(Comment cm);

    @Query("SELECT * FROM comment WHERE postId=:postId ")
    List<Comment> getCommentOfPost(final int postId);

    @Query("SELECT * FROM comment WHERE userId=:userId ")
    List<Comment> getCommentOfUser(final int userId);

    @Query("SELECT user_name FROM comment JOIN user JOIN post WHERE postId =:postId ")
    List<String> getUsers(final int postId);
}
