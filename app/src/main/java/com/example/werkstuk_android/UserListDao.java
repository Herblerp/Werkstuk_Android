package com.example.werkstuk_android;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface UserListDao {
    @Query("SELECT * FROM lists")
    List<ListWithEntries> getAll();

    @Query("SELECT * FROM lists WHERE userListId LIKE :id")
    ListWithEntries getById(int id);

    @Insert
    void insertList(UserList list);

}


