package com.example.ekbactivity;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    private ArrayList<News> newsArray = new ArrayList<>();
    private Context context;
    private LayoutInflater mInflater;

    public RecyclerViewAdapter(ArrayList<News> newsArray, NewsFragment context) {
        this.newsArray = newsArray;
        this.context = new MainActivity();
        this.mInflater = LayoutInflater.from(new MainActivity());
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = mInflater.inflate(R.layout.recycler_view_row_news, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder viewHolder, int i) {
        int img = newsArray.get(i).getNewsImg();
        viewHolder.img.setImageResource(img);
    }

    @Override
    public int getItemCount() {
        return newsArray.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private ImageView img;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            img = itemView.findViewById(R.id.news_box_img);
        }
    }
}
