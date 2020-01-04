package com.example.werkstuk_android;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class DisplayListsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_lists);
    }

    public void add_list(View view) {
        Log.i("DisplayListsActivityLog","Add lists pressed.");
        Intent displayList = new Intent(this, AddListActivity.class);
        startActivity(displayList);
    }
}
