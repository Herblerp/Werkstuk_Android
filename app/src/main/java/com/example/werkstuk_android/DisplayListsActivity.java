package com.example.werkstuk_android;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class DisplayListsActivity extends AppCompatActivity {

    public static final int LIST_TITLE_REQUEST = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_lists);
    }

    public void add_list(View view) {
        Log.i("DisplayListsActivityLog","Add lists pressed.");
        Intent displayList = new Intent(this, AddListActivity.class);
        startActivityForResult(displayList, LIST_TITLE_REQUEST);
    }

    public void onActivityResult(int requestCode, int resultCode,  Intent data) {
        super.onActivityResult(requestCode, resultCode,data);
        if(requestCode == LIST_TITLE_REQUEST){
            if(resultCode==RESULT_OK){

                String title = data.getStringExtra(AddListActivity.EXTRA_LIST_TITLE);
                Log.i("DevLog_List","Successfully received title: " + title);
            }
        }
    }
}
