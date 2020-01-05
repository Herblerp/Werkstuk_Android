package com.example.werkstuk_android;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class ListEntryFragment extends Fragment {

    private RecyclerView mRecyclerView;
    private ListEntryAdapter mAdapter;
    private AppRepository mRepo;
    private DisplayListEntriesActivity activity;



    public ListEntryFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        activity = (DisplayListEntriesActivity) getActivity();
        View rootView = inflater.inflate(R.layout.fragment_display_list_entries, container, false);
        mRecyclerView = rootView.findViewById(R.id.list_entry_recycler_view);
        return rootView;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState)
    {
        super.onActivityCreated(savedInstanceState);
        UpdateView();
    }

    public void UpdateView() {

        mRepo = new AppRepository(activity.getApplication());
        // Create an adapter and supply the data to be displayed.
        mAdapter = new ListEntryAdapter(activity, mRepo.getListById(activity.listId).entries);
        // Connect the adapter with the RecyclerView.
        mRecyclerView.setAdapter(mAdapter);
        // Give the RecyclerView a default layout manager.
        mRecyclerView.setLayoutManager(new LinearLayoutManager(activity));
    }
}
