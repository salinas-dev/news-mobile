package com.salinas.news_mobile.modelos;

import java.util.List;

public class NewsResponse {
    private List<News> articles;

    public List<News> getArticles() {
        return articles;
    }

    public void setArticles(List<News> articles) {
        this.articles = articles;
    }
}
