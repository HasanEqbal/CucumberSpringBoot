package com.cucumberspringboot.preference.utils;


import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;


@Configuration
public class AppConfig {

 public MongoClient mongoClientOSDC() {
        return MongoClients.create("mongodb://localhost:27017");
    }

    public @Bean(name="LocalTemplate") MongoTemplate mongoTemplateSource() {
        return new MongoTemplate(mongoClientOSDC(), "local");
    }

}
