package com.example.puza.evolve_android_assignment.adapter;



import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.puza.evolve_android_assignment.R;
import com.example.puza.evolve_android_assignment.model.Item;
import com.example.puza.evolve_android_assignment.ui.DisplayActivity;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {

    private Context mContext;
    private List<Item> itemList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView id, title, body;
        public CardView cardView;

        public MyViewHolder(View view) {
            super(view);
            id = (TextView)view.findViewById(R.id.id);
            title = (TextView) view.findViewById(R.id.title);
            body = (TextView) view.findViewById(R.id.body);
            cardView = (CardView) view.findViewById(R.id.cardview);

        }
    }


    public RecyclerViewAdapter(Context mContext, List<Item> itemList) {
        this.mContext = mContext;
        this.itemList = itemList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recycler_view_content, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder,final int position) {
        Item item = itemList.get(position);
        holder.id.setText("User Id : " + item.getUserId());
        holder.title.setText(item.getTitle());
        holder.body.setText(item.getBody());

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(mContext, DisplayActivity.class);
                intent.putExtra("id", itemList.get(position).getId());
                mContext.startActivity(intent);
            }
        });
    }


    @Override
    public int getItemCount() {
        //Log.v("size", itemList.size()+"");
        return itemList.size();
    }
}
