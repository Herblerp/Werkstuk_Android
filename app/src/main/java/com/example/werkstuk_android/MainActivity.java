package com.example.werkstuk_android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i("MainActivity","App sais hello!");
    }

    public void click_list_btn(View view) {
        Log.i("MainActivityLog","Display lists pressed.");
        Intent displayList = new Intent(this, DisplayListsActivity.class);
        startActivity(displayList);
    }

    public void click_cal_btn(View view) {

    }

    public void click_recipe_btn(View view) {

    }

    public void click_map_btn(View view) {

    }
}
