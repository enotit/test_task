package com.example.test_task.repositories.impls;

import com.example.test_task.model.Category;
import com.example.test_task.repositories.interfaces.ArticleRepository;
import com.mongodb.ReadConcern;
import com.mongodb.ReadPreference;
import com.mongodb.TransactionOptions;
import com.mongodb.WriteConcern;
import com.mongodb.client.ClientSession;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.example.test_task.model.Article;
import com.mongodb.client.MongoCursor;
import org.bson.BsonDocument;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

import static com.mongodb.client.model.Aggregates.group;
import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Filters.in;

@Repository
class ArticleRepositoryImpl implements ArticleRepository {
    private static final TransactionOptions txnOptions = TransactionOptions.builder()
            .readPreference(ReadPreference.primary())
            .readConcern(ReadConcern.MAJORITY)
            .writeConcern(WriteConcern.MAJORITY)
            .build();
    @Autowired
    private MongoClient mongoClient;

    @Value("${mongo.dbName}")
    private String databaseName;
    private MongoCollection<Article> articlesCollection;

    @PostConstruct
    void init() {
        articlesCollection = mongoClient.getDatabase(databaseName).getCollection("articles", Article.class);
    }

    @Override
    public Article save(Article article) {
        article.id = new ObjectId();
        articlesCollection.insertOne(article);
        return article;
    }

    @Override
    public List<Category> getAllCategories() {
        return articlesCollection.distinct("category", Category.class).into(new ArrayList<>());
    }

    @Override
    public List<Article> getAll() {
        return articlesCollection.find().into(new ArrayList<>());
    }

    @Override
    public Long deleteAll() {
        try (ClientSession clientSession = mongoClient.startSession()) {
            return clientSession.withTransaction(
                    () -> articlesCollection.deleteMany(clientSession, new BsonDocument()).getDeletedCount(), txnOptions);
        }
    }

    @Override
    public List<Article> getByCategory(String name) {
        return articlesCollection.find(eq("category.name", name)).into(new ArrayList<>());
    }

    @Override
    public Article getByID(String id) {
        return articlesCollection.find(eq("_id", new ObjectId(id))).first();
    }
}