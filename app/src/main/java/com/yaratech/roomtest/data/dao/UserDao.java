package com.yaratech.roomtest.data.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.yaratech.roomtest.data.table.User;

import java.util.List;

@Dao
public interface UserDao {

    @Insert
    public void insertUser(User users);

    @Query("Select * from user")
    List<User> getUserFromDb();
}
