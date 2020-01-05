//Source https://codelabs.developers.google.com/codelabs/android-training-create-recycler-view/#3
package com.example.werkstuk_android;

import android.content.Context;
import android.content.Intent;
import android.text.Layout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.werkstuk_android.R;

import java.util.LinkedList;
import java.util.List;

public class ListEntryAdapter extends RecyclerView.Adapter<ListEntryAdapter.ListViewHolder> {

    private Context appContext;
    private LayoutInflater mInflater;
    private final List<UserListEntry> myEntries;

    //public final static String EXTRA_LIST_ID = "com.example.werkstuk_android.LIST_ID";

    public ListEntryAdapter(Context context, List<UserListEntry> myEntries) {
        mInflater = LayoutInflater.from(context);
        this.myEntries = myEntries;
        this.appContext = context;
    }

    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View mItemView = mInflater.inflate(R.layout.list_item_entry,
                parent, false);
        return new ListViewHolder(mItemView, this);
    }

    @Override
    public void onBindViewHolder(@NonNull ListViewHolder holder, int position)
    {
        UserListEntry current = myEntries.get(position);
        holder.wordItemView.setText(current.content);
    }

    @Override
    public int getItemCount() {
        return myEntries.size();
    }

    class ListViewHolder extends RecyclerView.ViewHolder
    {
        public final TextView wordItemView;
        final ListEntryAdapter mAdapter;

        public ListViewHolder(View itemView, ListEntryAdapter adapter) {
            super(itemView);
            wordItemView = itemView.findViewById(R.id.entryContent);
            this.mAdapter = adapter;
        }
    }

    public static String capitalize(String str)
    {
        if(str == null) return str;
        return str.substring(0, 1).toUpperCase() + str.substring(1);
    }
}
