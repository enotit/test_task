package com.example.test_task.repositories.interfaces;

import com.example.test_task.model.Article;
import com.example.test_task.model.Category;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticleRepository {
    List<Article> getAll();
    Article getByID(String id);
    List<Article> getByCategory(String id);
    Long deleteAll();
    Article save(Article article);
    List<Category> getAllCategories();
}
