package com.example.werkstuk_android;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class DisplayListEntriesActivity extends AppCompatActivity {

    public int listId;
    private AppRepository mRepo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_list_entries);

        Intent intent = getIntent();
        listId = intent.getIntExtra(ListAdapter.EXTRA_LIST_ID,-1);

        mRepo = new AppRepository(getApplication());
    }

    public void add_list_entry(View view) {
        Log.i("DevLogList", "you added an item!");
        UserListEntry entry = new UserListEntry();
        entry.content = "Niks";
        entry.userListId = listId;
        mRepo.insertEntry(entry);
    }
}
