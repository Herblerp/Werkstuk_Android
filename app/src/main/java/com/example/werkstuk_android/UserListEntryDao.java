package com.example.werkstuk_android;

import androidx.room.Dao;
import androidx.room.Insert;

@Dao
public interface UserListEntryDao {
    @Insert
    void insertEntry(UserListEntry entry);
}
