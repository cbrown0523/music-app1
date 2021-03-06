package com.christine.music.app1.payloads.ApiResponse;

import java.util.List;

//payload definition 18
public class NewsApi {
    private String status;
    private Integer totalResults;
    //why arnt  List<Article> used in constructor
    private List<Article> articles;

    public NewsApi() {
    }

    public NewsApi(String status, Integer totalResults) {
        this.status = status;
        this.totalResults = totalResults;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(Integer totalResults) {
        this.totalResults = totalResults;
    }

    public List<Article> getArticles() {
        return articles;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }
}
