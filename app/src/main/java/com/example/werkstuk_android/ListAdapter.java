//Code from https://codelabs.developers.google.com/codelabs/android-training-create-recycler-view/#3
package com.example.werkstuk_android;

import android.content.Context;
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

    private LayoutInflater mInflater;
    private final List<ListWithEntries> myLists;

    public ListAdapter(Context context, List<ListWithEntries> myLists) {
        mInflater = LayoutInflater.from(context);
        this.myLists = myLists;
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
        holder.wordItemView.setText(current.list.title);
    }

    @Override
    public int getItemCount() {
        return myLists.size();
    }

    class ListViewHolder extends RecyclerView.ViewHolder
    {
        public final TextView wordItemView;
        final ListAdapter mAdapter;

        public ListViewHolder(View itemView, ListAdapter adapter) {
            super(itemView);
            wordItemView = itemView.findViewById(R.id.listTitle);
            this.mAdapter = adapter;
        }
    }
}
