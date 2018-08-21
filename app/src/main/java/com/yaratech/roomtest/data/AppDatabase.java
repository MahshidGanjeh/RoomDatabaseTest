package com.yaratech.roomtest.data;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.yaratech.roomtest.data.dao.CommentDao;
import com.yaratech.roomtest.data.dao.PostDao;
import com.yaratech.roomtest.data.dao.UserDao;
import com.yaratech.roomtest.data.table.Comment;
import com.yaratech.roomtest.data.table.Post;
import com.yaratech.roomtest.data.table.User;

@Database(entities = {User.class, Post.class, Comment.class}, version = 8, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {
    private static AppDatabase INSTANCE;

    public abstract UserDao userDao();

    public abstract PostDao postDao();

    public abstract CommentDao commentDao();

    public static AppDatabase getAppDatabase(Context context) {
        if (INSTANCE == null) {
            INSTANCE =
                    Room.databaseBuilder(context.getApplicationContext(), AppDatabase.class,
                            "user-database")
                            .fallbackToDestructiveMigration()
                            .build();
        }
        return INSTANCE;
    }

    public static void destroyInstance() {
        INSTANCE = null;
    }
}
