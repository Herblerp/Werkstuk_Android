package com.example.werkstuk_android;


import android.app.Application;
import android.os.AsyncTask;
import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;

import java.util.List;
import java.util.Observable;
import java.util.concurrent.ExecutionException;

public class AppRepository{

    private UserListDao mUserListDao;
    private UserListEntryDao mUserListEntryDao;

    public AppRepository(Application application) {
        AppDatabase db = AppDatabase.getDatabase(application);
        mUserListDao = db.userListDao();
        mUserListEntryDao = db.userListEntryDao();
    }

    public void insertList(UserList list) {

        mUserListDao.insertList(list);
    }

    public List<ListWithEntries> getLists() {
        return mUserListDao.getAll();
    }

    public ListWithEntries getListById(int id) {
        return mUserListDao.getById(id);
    }

    public void insertEntry(UserListEntry entry) {
        mUserListEntryDao.insertEntry(entry);
    }

    public String getRandomRecipeAsync() {

        //Some url endpoint that you may have
        String myUrl = "https://www.themealdb.com/api/json/v1/1/random.php";

        //String to place our result in
        String result = "";

        HttpGetRequest getRequest = new HttpGetRequest();

        try {
            result = getRequest.execute(myUrl).get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        return result;
    }
}

