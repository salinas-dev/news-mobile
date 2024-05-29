package com.salinas.news_mobile;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.salinas.news_mobile.modelos.News;

import java.util.List;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.NewsViewHolder> {
    private List<News> newsList;

    public NewsAdapter(List<News> newsList) {
        this.newsList = newsList;
    }

    @NonNull
    @Override
    public NewsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_news_list, parent, false);
        return new NewsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NewsViewHolder holder, int position) {
        News news = newsList.get(position);
        holder.titleTextView.setText(news.getTitle());
        holder.descriptionTextView.setText(news.getDescription());
        //holder.publishedAtView.setText(news.getPublishedAt());
        //holder.contentView.setText(news.getContent());
        Glide.with(holder.itemView.getContext()).load(news.getUrlToImage()).into(holder.imageView);


        // Configuración del clic del botón "Ver detalles"
        holder.viewDetailsButton.setOnClickListener(v -> {
            Intent intent = new Intent(holder.itemView.getContext(), NewsDetails.class);
            intent.putExtra("title", news.getTitle());
            intent.putExtra("author", news.getAuthor());
            intent.putExtra("description", news.getDescription());
            intent.putExtra("publishedAt", news.getPublishedAt());
            intent.putExtra("content", news.getContent());
            intent.putExtra("urlToImage", news.getUrlToImage());
            holder.itemView.getContext().startActivity(intent);
        });


    }

    @Override
    public int getItemCount() {
        return newsList.size();
    }

    public static class NewsViewHolder extends RecyclerView.ViewHolder {
        TextView titleTextView;
        TextView descriptionTextView;
        ImageView imageView;
        TextView publishedAtView;
        //TextView contentView;

        Button viewDetailsButton;
        public NewsViewHolder(@NonNull View itemView) {
            super(itemView);
            titleTextView = itemView.findViewById(R.id.titleTextView);
            descriptionTextView = itemView.findViewById(R.id.descriptionTextView);
            imageView = itemView.findViewById(R.id.imageView);
            viewDetailsButton = itemView.findViewById(R.id.viewDetailsButton);
            //publishedAtView = itemView.findViewById(R.id.publishedAtView);
            //contentView = itemView.findViewById(R.id.contentView);
        }
    }
}