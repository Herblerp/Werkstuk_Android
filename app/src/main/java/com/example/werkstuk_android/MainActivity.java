package com.example.werkstuk_android;

import androidx.appcompat.app.AppCompatActivity;

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

    public void button_click(View view) {
        Button button = findViewById(R.id.btn_homepage_lists);
        button.setText("You clicked me!");
    }
}
