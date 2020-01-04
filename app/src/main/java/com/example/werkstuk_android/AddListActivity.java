package com.example.werkstuk_android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

public class AddListActivity extends AppCompatActivity {

    public final static String EXTRA_LIST_TITLE = "com.example.werkstuk_android.LIST_TITLE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_list);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.add_list_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        Intent returnIntent = new Intent();

        if (item.getItemId() == R.id.action_submit) {
            Log.i("DevLog_List","New list form submitted.");

            TextView textview_list_title = findViewById(R.id.textview_list_title);
            String list_title = textview_list_title.getText().toString();

            if(list_title.equals("")){
                Log.i("DevLog_List","com.example.werkstuk_android.List title empty, showing toast.");
                showEmptyTitleMessage();
                return false;
            }

            returnIntent.putExtra(EXTRA_LIST_TITLE,list_title);
            setResult(RESULT_OK,returnIntent);

            finish();
            return true;
        }
        Log.i("DevLog_List","New list form canceled.");
        setResult(RESULT_CANCELED,returnIntent);

        finish();
        return false;
    }

    private void showEmptyTitleMessage() {
        Toast toast = Toast.makeText(getApplicationContext(),
                R.string.toast_empty_list_title,
                Toast.LENGTH_SHORT);

        toast.show();
    }
}
