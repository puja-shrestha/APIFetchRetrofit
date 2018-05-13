package com.example.puza.evolve_android_assignment.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.puza.evolve_android_assignment.R;
import com.example.puza.evolve_android_assignment.model.DisplayItem;
import java.util.List;

public class DisplayRecyclerAdapter extends RecyclerView.Adapter<DisplayRecyclerAdapter.MyViewHolder> {

    private Context mContext;
    private List<DisplayItem> displayItems;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView postId, id, name, email, body;


        public MyViewHolder(View view) {
            super(view);
            postId = (TextView)view.findViewById(R.id.postId);
            id = (TextView) view.findViewById(R.id.id);
            name = (TextView) view.findViewById(R.id.name);
            email = (TextView) view.findViewById(R.id.email);
            body = (TextView) view.findViewById(R.id.body);
        }
    }


    public DisplayRecyclerAdapter(Context mContext, List<DisplayItem> displayItems) {
        this.mContext = mContext;
        this.displayItems = displayItems;
    }

    @Override
    public DisplayRecyclerAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.content_display_item, parent, false);

        return new DisplayRecyclerAdapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final DisplayRecyclerAdapter.MyViewHolder holder, int position) {
        DisplayItem displayItem = displayItems.get(position);
        holder.postId.setText("User Id : " + displayItem.getPostId());
        holder.id.setText(displayItem.getId());
        holder.name.setText(displayItem.getName());
        holder.email.setText(displayItem.getEmail());
        holder.body.setText(displayItem.getBody());
    }


    @Override
    public int getItemCount() {
        return displayItems.size();
    }
}