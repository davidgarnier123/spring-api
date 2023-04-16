package com.example.demo.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

@RestController
@RequestMapping("/api/v1/tv")
public class apitv {


    @Autowired
    private MongoClient mongoClientTv;

    @GetMapping("/channels")
    public List<Object> getChannels() {
        System.out.println("Request channels");
        List<Object> data = new ArrayList<>();
        MongoDatabase database = mongoClientTv.getDatabase("tv");
        MongoCollection<org.bson.Document> collection = database.getCollection("channels");
        FindIterable<org.bson.Document> documents = collection.find();
        for (org.bson.Document doc : documents) {
            data.add(doc);
        }
        return data;
    }

    @GetMapping("/programs")
    public List<Object> getPrograms() {
        System.out.println("Request programs");
        List<Object> data = new ArrayList<>();
        MongoDatabase database = mongoClientTv.getDatabase("tv");
        MongoCollection<org.bson.Document> collection = database.getCollection("programs");
        FindIterable<org.bson.Document> documents = collection.find();
        for (org.bson.Document doc : documents) {
            data.add(doc);
        }
        return data;
    }

}
