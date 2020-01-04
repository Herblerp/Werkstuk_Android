package com.example.werkstuk_android;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {UserList.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {

    public abstract UserListDao userListDao();

    static AppDatabase getDatabase(final Context context)
    {
        return Room.databaseBuilder(
                context.getApplicationContext(),
                AppDatabase.class,
                "app_database").build();
    }

}