package com.example.test_task.model;


import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

public class Category {
    public String name;
    public String description;
    public String photo;

    public Category(){}

    public Category(String name, String description, String photo) {
        this.name = name;
        this.description = description;
        this.photo = photo;
    }

    @Override
    public String toString() {
        return "Category{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", photo='" + photo + '\'' +
                '}';
    }
}
