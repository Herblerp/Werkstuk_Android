package com.example.werkstuk_android;


import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;

import java.util.List;
import java.util.Observable;

public class AppRepository {

    private UserListDao mUserListDao;
    private UserListEntryDao mUserListEntryDao;

    public AppRepository (Application application) {
        AppDatabase db = AppDatabase.getDatabase(application);
        mUserListDao = db.userListDao();
        mUserListEntryDao = db.userListEntryDao();
    }

    public void insertList(UserList list){

        mUserListDao.insertList(list);
    }

    public List<ListWithEntries> getLists(){
       return mUserListDao.getAll();
    }

    public ListWithEntries getListById(int id)
    {
        return mUserListDao.getById(id);
    }

    public void insertEntry(UserListEntry entry)
    {
        mUserListEntryDao.insertEntry(entry);
    }
}

