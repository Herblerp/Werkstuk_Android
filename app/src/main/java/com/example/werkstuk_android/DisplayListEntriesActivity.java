package com.example.werkstuk_android;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

public class DisplayListEntriesActivity extends AppCompatActivity implements AddEntryFragment.AddEntryBtnListener{

    public int listId;
    private AppRepository mRepo;

    private static final String LIST_TAG = "list";

    //AddEntryFragment addEntryFragment;
    ListEntryFragment listEntryFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_list_entries);

        Intent intent = getIntent();
        listId = intent.getIntExtra(ListAdapter.EXTRA_LIST_ID,-1);

        mRepo = new AppRepository(getApplication());

        FragmentManager fragmentManager = getSupportFragmentManager();
        listEntryFragment = (ListEntryFragment) fragmentManager.findFragmentByTag(LIST_TAG);
        if (listEntryFragment == null)
        {
            listEntryFragment = new ListEntryFragment();
            fragmentManager.beginTransaction().add(R.id.entry_list_frame,listEntryFragment,LIST_TAG).commit();
        }
    }

    public void add_list_entry(String content) {
        Log.i("DevLogList", "Adding entry to list.");
        UserListEntry entry = new UserListEntry();
        entry.content = content;
        entry.userListId = listId;
        mRepo.insertEntry(entry);
    }

    @Override
    public void addButtonPressed(String content) {
        Log.i("DevLog","Callback received content!");
        add_list_entry(content);
        listEntryFragment.UpdateView();
    }
}
