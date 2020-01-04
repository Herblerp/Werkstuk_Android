package com.example.werkstuk_android;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "list_entries")
public class UserListEntry {
    @PrimaryKey
    public int listEntryId;

    @ColumnInfo(name="listId")
    public int userListId;

    @ColumnInfo(name="content")
    public String content;
}
