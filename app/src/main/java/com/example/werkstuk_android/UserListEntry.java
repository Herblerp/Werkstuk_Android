package com.example.werkstuk_android;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "list_entries")
public class UserListEntry {

    public UserListEntry(){ }

    @PrimaryKey(autoGenerate = true)
    public int listEntryId;

    public int userListId;
    public String content;
}
