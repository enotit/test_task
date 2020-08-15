package com.example.test_task;

import model.Article;
import model.Category;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface DBInterface extends MongoRepository<Article, String> {
}
