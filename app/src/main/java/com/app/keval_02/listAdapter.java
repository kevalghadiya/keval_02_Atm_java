package com.app.keval_02;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class listAdapter extends RecyclerView.Adapter<listAdapter.ItemViewHolder> {
    ArrayList<String> data =new ArrayList<>();

    public listAdapter(ArrayList<String> data) {
        this.data = data;
    }

    @NonNull
    @Override
    public listAdapter.ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adaper_list,parent,false);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull listAdapter.ItemViewHolder holder, int position) {
        holder.tvTable.setText(data.get(position));
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder {
        TextView tvTable;
        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTable =itemView.findViewById(R.id.tvTable);
        }
    }
}
