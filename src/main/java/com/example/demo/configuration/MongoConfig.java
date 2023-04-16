package com.example.demo.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;

@Configuration
public class MongoConfig {
    @Value("${spring.data.mongodb.uri.tv}")
    private String mongoUriTv;
    @Value("${spring.data.mongodb.uri.loto}")
    private String mongoUriLoto;
    @Bean
    public MongoClient mongoClientTv() {
        MongoClientSettings settings = MongoClientSettings.builder()
                .applyConnectionString(new ConnectionString(mongoUriTv))
                .build();
        return MongoClients.create(settings);
    }

    @Bean
    public MongoClient mongoClientLoto() {
        MongoClientSettings settings = MongoClientSettings.builder()
                .applyConnectionString(new ConnectionString(mongoUriLoto))
                .build();
        return MongoClients.create(settings);
    }
}