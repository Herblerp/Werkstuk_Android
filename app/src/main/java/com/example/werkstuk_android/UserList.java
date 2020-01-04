package com.example.werkstuk_android;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "lists")
public class UserList {

    public UserList(){}

    @PrimaryKey(autoGenerate = true)
    public int userListId;

    public String title;
}
