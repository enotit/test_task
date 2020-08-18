//package com.example.test_task;
//
//import model.Article;
//import model.Category;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
//
//import java.util.ArrayList;
//import java.util.List;
//
////@SpringBootApplication
////@EnableMongoRepositories(basePackageClasses = DBhandler.class)
//public class DBhandler {
//    @Autowired
//    public static DBInterface data;
//
//    public static void main(String[] args){
//        data.deleteAll();
//
//        Category car = new Category("Auto", "In this category we will talk about cars.", "https://s1.1zoom.ru/b5050/458/294916-svetik_1920x1200.jpg");
//        Category moto = new Category("Motorcycle", "In this category we will talk about motorcycles.", "https://img3.goodfon.ru/original/2048x1536/2/62/moto-bayk-cheper.jpg");
//        Category truck = new Category("Truck", "In this category we will talk about trucks.", "https://w-dog.ru/wallpapers/0/28/309432582692707/freightliner-gruzovik.jpg");
//        data.save(new Article("LADA GRANTA", "Russian budget car", "https://pol-z.ru/wp-content/uploads/2015/03/225.jpg", car));
//        data.save(new Article("BMW 2008-12 HP2 Sport", "just motorcycle", "https://bmwwiki.ru/wp-content/uploads/2019/05/bmw-hp2-sport-9-1024x768.jpg", moto));
//        data.save(new Article("Big bibika", "here enough logic", "https://www.peoples.ru/character/movie/optimus_prime/optimus_4.jpg", truck));
//        data.save(new Article("Small four-wheeled animal", "Mquin", "https://vk.vkfaces.com/858436/v858436897/1246b0/i85oZwOuhQo.jpg", car));
//
//        System.out.println("Accept connect to DataBase.");
//    }
//    public static List<Category> GetCategories() {
//        List<Category> res = new ArrayList<>();
//        var a = data.findAll();
//        for (Article i: a) if (!res.contains(i.category)) res.add(i.category);
//        return res;
//    }
//}
