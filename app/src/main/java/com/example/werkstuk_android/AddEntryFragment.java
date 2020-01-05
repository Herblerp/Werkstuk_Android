package com.example.werkstuk_android;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;

public class AddEntryFragment extends Fragment {

    public AddEntryFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.fragment_add_list_entry, container, false);

        //Button addButton = view.findViewById(R.id.)

        return view;
    }

}
