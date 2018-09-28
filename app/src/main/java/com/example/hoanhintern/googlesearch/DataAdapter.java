package com.example.hoanhintern.googlesearch;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.Viewholder> {
    private List<Result> results;
    private Context context;

    public DataAdapter(List<Result> results, Context context) {
        this.results = results;
        this.context = context;
    }

    @Override
    public DataAdapter.Viewholder onCreateViewHolder(ViewGroup parent, int viewType) {

        View itemView;

        itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.data_row,parent,false);

        return new Viewholder(itemView);

    }

    @Override
    public void onBindViewHolder(@NonNull DataAdapter.Viewholder holder, int position) {
        Result result = results.get(position);
        String title = result.getTitle();
        String url = result.getUrl();

        holder.tvTitle.setText(title);
        holder.tvLink.setText(url);

    }

    @Override
    public int getItemCount() {
        return results.size();
    }

    public class Viewholder extends RecyclerView.ViewHolder {
        private TextView tvTitle;
        private TextView tvLink;
        public Viewholder(View itemView) {
            super(itemView);

            tvTitle = (TextView)itemView.findViewById(R.id.txTitle);
            tvLink = (TextView)itemView.findViewById(R.id.txLink);

        }
    }
}
