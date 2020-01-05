package com.example.werkstuk_android;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.migration.Migration;

@Database(entities = {UserList.class, UserListEntry.class}, version = 2)
public abstract class AppDatabase extends RoomDatabase {

    public abstract UserListDao userListDao();
    public abstract UserListEntryDao userListEntryDao();

    static AppDatabase getDatabase(final Context context)
    {
        return Room.databaseBuilder(
                context.getApplicationContext(),
                AppDatabase.class,
                "app_database")
                .allowMainThreadQueries()
                .build();
    }

}