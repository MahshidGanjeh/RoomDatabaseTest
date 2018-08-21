package com.yaratech.roomtest.data.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;

import com.yaratech.roomtest.data.table.Post;

@Dao
public interface PostDao {

    @Insert
     void insertPost(Post post);

}
