// Source: https://stackoverflow.com/questions/13700798/basic-communication-between-two-fragments
package com.example.werkstuk_android;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.werkstuk_android.R;

public class AddEntryFragment extends Fragment {

    private AddEntryBtnListener mCallback;
    View rootview;

    public AddEntryFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState){
        rootview = inflater.inflate(R.layout.fragment_add_list_entry, container, false);

        Button addButton = rootview.findViewById(R.id.btn_add_list_item);

        addButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v){

                TextView textview = rootview.findViewById(R.id.list_entry_content);
                String content = textview.getText().toString();
                mCallback.addButtonPressed(content);
            }
        });

        return rootview;
    }

    public interface AddEntryBtnListener {
        void addButtonPressed(String text);
    }

    @Override
    public void onAttach(Context context){
        super.onAttach(context);
        if(context instanceof AddEntryBtnListener){
            mCallback = (AddEntryBtnListener) context;
        }else{
            throw new RuntimeException(context.toString() + " must implement BtnListener!");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mCallback = null;
    }

}
