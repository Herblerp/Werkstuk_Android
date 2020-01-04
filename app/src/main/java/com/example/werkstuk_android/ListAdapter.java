//Code from https://codelabs.developers.google.com/codelabs/android-training-create-recycler-view/#3
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

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ListViewHolder> {

    private Context appContext;
    private LayoutInflater mInflater;
    private final List<ListWithEntries> myLists;

    public final static String EXTRA_LIST_ID = "com.example.werkstuk_android.LIST_ID";

    public ListAdapter(Context context, List<ListWithEntries> myLists) {
        mInflater = LayoutInflater.from(context);
        this.myLists = myLists;
        this.appContext = context;
    }

    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View mItemView = mInflater.inflate(R.layout.list_item,
                parent, false);
        return new ListViewHolder(mItemView, this);
    }

    @Override
    public void onBindViewHolder(@NonNull ListViewHolder holder, int position)
    {
        ListWithEntries current = myLists.get(position);
        holder.wordItemView.setText(capitalize(current.list.title));
    }

    @Override
    public int getItemCount() {
        return myLists.size();
    }

    class ListViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener
    {
        public final TextView wordItemView;
        final ListAdapter mAdapter;

        public ListViewHolder(View itemView, ListAdapter adapter) {
            super(itemView);
            wordItemView = itemView.findViewById(R.id.listTitle);
            this.mAdapter = adapter;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {

            int position = getLayoutPosition();
            ListWithEntries list = myLists.get(position);

            Log.d("DevLog_ListAdapter","clicked list with id: " + list.list.userListId);

            Intent intent = new Intent(appContext,DisplayListEntriesActivity.class);
            intent.putExtra("com.example.werkstuk_android.LIST_ID",list.list.userListId);
            appContext.startActivity(intent);
        }
    }

    public static String capitalize(String str)
    {
        if(str == null) return str;
        return str.substring(0, 1).toUpperCase() + str.substring(1);
    }
}
