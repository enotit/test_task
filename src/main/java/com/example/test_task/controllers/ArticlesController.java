package com.example.test_task.controllers;

import com.example.test_task.repositories.interfaces.ArticleRepository;
import com.example.test_task.model.Article;
import com.example.test_task.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Component
public class ArticlesController {
    @Autowired
    private final ArticleRepository articleRepository;

    public ArticlesController(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    /**
     * @return help text string
     */
    @GetMapping("/help")
    public String help() {
        return "localhost/*\ncategories\narticles/name\narticles\nfromcategory/name";
    }

    /**
     * @return all exclusive categories
     */
    @GetMapping("/categories")
    public List<Category> getCategories(){
        return articleRepository.getAllCategories();
    }

    /**
     * This GET Method for receivings Article by Id
     * @param id`s article you want to return
     * @return article as JSON when id`s article equals param
     */
    @GetMapping("/articles/{id}")
    public Article getArticleByID(@PathVariable("id") String id) {
        return articleRepository.getByID(id);
    }

    /**
     * @return List all Articles in DataBase
     */
    @GetMapping("/articles")
    public List<Article> getAllArticles() {
        return articleRepository.getAll();
    }

    /**
     * This GET Method
     * @param name is title category the list of which should return
     * @return List Articles where name category equals name
     */
    @GetMapping("/fromcategory/{name}")
    public List<Article> getArticlesByCategory(@PathVariable("name") String name) {
        return articleRepository.getByCategory(name);
    }

    /**
     * This POST Method for add in DataBase article
     * @param article - json string
     * @return article added earlier
     */
    @PostMapping("/articles")
    public Article createArticle(@RequestBody Article article) {
        return articleRepository.save(article);
    }
}