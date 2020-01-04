package com.example.werkstuk_android;


import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;

import java.util.List;
import java.util.Observable;

public class AppRepository {

    private UserListDao mUserListDao;

    public AppRepository (Application application) {
        AppDatabase db = AppDatabase.getDatabase(application);
        mUserListDao = db.userListDao();
    }

    public void insertList(UserList list){

        mUserListDao.insertList(list);
    }

    public List<ListWithEntries> getLists(){
       return mUserListDao.getAll();
    }
}

