package com.salinas.news_mobile;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.salinas.news_mobile.modelos.News;
import com.salinas.news_mobile.modelos.NewsResponse;
import com.salinas.news_mobile.modelos.NewsApi;
import com.salinas.news_mobile.modelos.NewsRetrofit;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private NewsAdapter newsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        fetchNews();
    }

    private void fetchNews() {
        NewsApi newsApi = NewsRetrofit.getRetrofitInstance().create(NewsApi.class);
        Call<NewsResponse> call = newsApi.getTopHeadlines("us", "dd24b87bddf040a19785025734603845");

        call.enqueue(new Callback<NewsResponse>() {
            @Override
            public void onResponse(Call<NewsResponse> call, Response<NewsResponse> response) {
                if (response.isSuccessful() && response.body() != null) {
                    List<News> newsList = response.body().getArticles();
                    newsAdapter = new NewsAdapter(newsList);
                    recyclerView.setAdapter(newsAdapter);
                }
            }

            @Override
            public void onFailure(Call<NewsResponse> call, Throwable t) {
                Log.e("MainActivity", "Error", t);
            }
        });


    }
}