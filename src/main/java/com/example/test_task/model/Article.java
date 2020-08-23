package com.example.test_task.model;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

public class Article {
    @Id
    public ObjectId id;
    public String name;
    public String description;
    public String photo;
    public Category category;

    public Article(String name, String description, String photo, Category category) {
        this.name = name;
        this.description = description;
        this.photo = photo;
        this.category = category;
    }

    public Article() {}

    @Override
    public String toString() {
        return "Article{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", photo='" + photo + '\'' +
                ", category=" + category +
                '}';
    }
}
