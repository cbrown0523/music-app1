package com.christine.music.app1.controllers;

import com.christine.music.app1.payloads.ApiResponse.Article;
import com.christine.music.app1.payloads.ApiResponse.NewsApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("api/news")
public class NewsController {
    @Autowired
    Environment env;

    @GetMapping("test")
    public ResponseEntity<?>test(){

        return new ResponseEntity<>("testing" , HttpStatus.OK);
    }
    @GetMapping("/")
    public ResponseEntity<?>getMusicArticle(RestTemplate restTemplate){

        String key = env.getProperty("newsApiKey");
        String uri = "https://newsapi.org/v2/everything?apikey=" + key + "&q=music";
        NewsApi response = restTemplate.getForObject(uri, NewsApi.class);

        List<Article> articleList = new ArrayList<>();
        for(Article article : response.getArticles()){
            if(article.getSourceName().equals("Wired") ){
                articleList.add(article);
            }
        }
//        System.out.println(response.getStatus());
//        System.out.println(response.getArticles().get(0).getTitle());
        return new ResponseEntity<>(articleList , HttpStatus.OK);
    }

}
