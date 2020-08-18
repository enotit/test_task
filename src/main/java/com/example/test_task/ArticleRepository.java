package com.example.test_task;

import model.Article;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticleRepository {
    List<Article> findAll();


    Long deleteAll();

    Article save(Article article);
}
