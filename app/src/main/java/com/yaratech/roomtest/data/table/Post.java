package com.yaratech.roomtest.data.table;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;

import static android.arch.persistence.room.ForeignKey.CASCADE;

@Entity(tableName = "post", foreignKeys = @ForeignKey(entity = User.class,
        parentColumns = "uid",
        childColumns = "userId",
        onDelete = CASCADE))
public class Post {

    @PrimaryKey(autoGenerate = true)
    private int pid;

    @ColumnInfo(name = "userId")
    public int userId;

    public Post(int userId, String title, String description, String imageSource) {
        this.userId = userId;
        this.title = title;
        this.description = description;
        this.imageSource = imageSource;
    }

    @ColumnInfo(name = "title")

    private String title;

    @ColumnInfo(name = "description")
    private String description;

    @ColumnInfo(name = "image_source")
    private String imageSource;

    public void setPid(int pid) {
        this.pid = pid;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setImageSource(String imageSource) {
        this.imageSource = imageSource;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getImageSource() {
        return imageSource;
    }

    public int getUserId() {
        return userId;
    }

    public int getPid() {
        return pid;
    }
}
