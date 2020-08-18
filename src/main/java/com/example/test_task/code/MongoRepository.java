package com.example.test_task.code;

import com.example.test_task.ArticleRepository;
import com.mongodb.ReadConcern;
import com.mongodb.ReadPreference;
import com.mongodb.TransactionOptions;
import com.mongodb.WriteConcern;
import com.mongodb.client.ClientSession;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import model.Article;
import org.bson.BsonDocument;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

import static com.mongodb.client.model.Aggregates.group;
import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Filters.in;

@Repository
class MongoDBPersonRepository implements ArticleRepository {

    private static final TransactionOptions txnOptions = TransactionOptions.builder()
            .readPreference(ReadPreference.primary())
            .readConcern(ReadConcern.MAJORITY)
            .writeConcern(WriteConcern.MAJORITY)
            .build();
    @Autowired
    private MongoClient mongoClient;
    private MongoCollection<Article> personCollection;

    @PostConstruct
    void init() {
        personCollection = mongoClient.getDatabase("test").getCollection("article", Article.class);
    }

    @Override
    public Article save(Article person) {
        person.id = new ObjectId();
        personCollection.insertOne(person);
        return person;
    }


    @Override
    public List<Article> findAll() {
        return personCollection.find().into(new ArrayList<>());
    }


    @Override
    public Long deleteAll() {
        try (ClientSession clientSession = mongoClient.startSession()) {
            return clientSession.withTransaction(
                    () -> personCollection.deleteMany(clientSession, new BsonDocument()).getDeletedCount(), txnOptions);
        }
    }



}