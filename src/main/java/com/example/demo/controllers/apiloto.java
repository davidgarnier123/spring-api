package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/loto")
public class apiloto {
    @Autowired
    private MongoClient mongoClientLoto;
    @GetMapping("/results")
    public List<Object> getChannels() {
        System.out.println("Request results");
        List<Object> data = new ArrayList<>();
        MongoDatabase database = mongoClientLoto.getDatabase("loto");
        MongoCollection<org.bson.Document> collection = database.getCollection("results");
        FindIterable<org.bson.Document> documents = collection.find();
        for (org.bson.Document doc : documents) {
            data.add(doc);
        }
        return data;
    }
}
