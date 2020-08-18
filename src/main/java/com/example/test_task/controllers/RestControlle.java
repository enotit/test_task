package com.example.test_task.controllers;

import com.example.test_task.ArticleRepository;
import model.Article;
import model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Component
public class RestControlle {
    @Autowired
    private final ArticleRepository articleRepository;

    public RestControlle(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    @GetMapping("/help")
    public String help() {
        // List Category
        return "localhost/*\ncategories\narticles/name\narticle/name";
    }
    @GetMapping("/categories")
    public List<Category> get_categories(){
        List<Category> categories = null;
        for (Article a: articleRepository.findAll()) {
            if (!categories.contains(a.category)) categories.add(a.category);
        }
        return categories;
    }

    @RequestMapping("/articles/{id}")
    public String get_articles(@PathVariable("id")int id) {
        return "9778";
    }
}