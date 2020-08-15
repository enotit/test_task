package model;

import java.util.List;

public class Article {
    public String name;
    public String description;
    public String photo;
    public Category category;

    public Article() {
    }

    public Article(String name, String description, String photo, Category category) {
        this.name = name;
        this.description = description;
        this.photo = photo;
        this.category = category;
    }

    @Override
    public String toString() {
        return "Article{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", photo='" + photo + '\'' +
                ", category=" + category +
                '}';
    }
}
