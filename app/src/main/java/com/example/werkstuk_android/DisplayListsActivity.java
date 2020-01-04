package com.example.werkstuk_android;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.app.Application;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;

import java.util.List;

public class DisplayListsActivity extends AppCompatActivity {

    public static final int LIST_TITLE_REQUEST = 1;
    private RecyclerView mRecyclerView;
    private ListAdapter mAdapter;
    private AppRepository mRepo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_lists);
        mRepo = new AppRepository(getApplication());
        UpdateView();
    }

    public void add_list(View view) {
        Log.i("Devlog_List","Add lists pressed.");
        Intent displayList = new Intent(this, AddListActivity.class);
        startActivityForResult(displayList, LIST_TITLE_REQUEST);
    }

    public void onActivityResult(int requestCode, int resultCode,  Intent data) {
        super.onActivityResult(requestCode, resultCode,data);
        if(requestCode == LIST_TITLE_REQUEST){
            if(resultCode==RESULT_OK){

                String title = data.getStringExtra(AddListActivity.EXTRA_LIST_TITLE);
                Log.i("DevLog_List","Successfully received title: " + title);

                AppRepository repo = new AppRepository(getApplication());
                UserList newList = new UserList();
                newList.title = title;
                repo.insertList(newList);
                UpdateView();
            }
        }
    }

    private void UpdateView()
    {
        // Get a handle to the RecyclerView.
        mRecyclerView = findViewById(R.id.recyclerview);
        // Create an adapter and supply the data to be displayed.
        mAdapter = new ListAdapter(this, mRepo.getLists());
        // Connect the adapter with the RecyclerView.
        mRecyclerView.setAdapter(mAdapter);
        // Give the RecyclerView a default layout manager.
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}
