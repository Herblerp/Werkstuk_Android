package com.example.werkstuk_android;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class DisplayListEntriesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_list_entries);
    }

    public void add_list_entry(View view) {
        Log.i("DevLogList", "you added an item!");
    }
}
