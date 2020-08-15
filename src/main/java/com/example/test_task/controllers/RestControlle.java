package com.example.test_task.controllers;

import com.example.test_task.Application;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestControlle {

    @GetMapping("/help")
    public String help() {
        // List Category
        return "localhost/*\nget_categories\nget_articles?name=\nget_article?name=";
    }
    @GetMapping("/get_categories")
    public String getCat(){
        return new Application().GetCategories();
    }
    @RequestMapping("/get_articles")
    public String get_articles(@RequestParam(value = "name", required = false, defaultValue = "null") String name) {
        if (name.equals("null")) return "";
        return "9778";
    }
}