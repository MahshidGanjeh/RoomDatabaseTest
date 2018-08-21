package com.yaratech.roomtest.data.table;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "user")
public class User {

    @PrimaryKey(autoGenerate = true)
    private int uid;

    @ColumnInfo(name = "first_name")
    private String firstName;

    @ColumnInfo(name = "last_name")
    private String lastName;

    @ColumnInfo(name = "national_id")
    private int nationalId;

    @ColumnInfo(name = "avatar")
    private String avatar;

    public User(String firstName, String lastName, int nationalId, String avatar) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.nationalId = nationalId;
        this.avatar = avatar;
    }

    public User() {
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setNationalId(int nationalId) {
        this.nationalId = nationalId;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public int getUid() {

        return uid;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getNationalId() {
        return nationalId;
    }

    public String getAvatar() {
        return avatar;
    }
}
