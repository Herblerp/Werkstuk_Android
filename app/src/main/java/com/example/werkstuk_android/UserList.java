package com.example.werkstuk_android;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "lists")
public class UserList {

    @PrimaryKey
    public int userListId;

    @ColumnInfo(name = "content")
    public String content;
}
