package model;

import java.util.ArrayList;
import java.util.List;

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
