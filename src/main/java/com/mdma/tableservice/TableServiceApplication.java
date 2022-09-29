package com.mdma.tableservice;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.awt.*;
import java.util.List;
import java.util.UUID;

@SpringBootApplication
public class    TableServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(TableServiceApplication.class, args);
    }

}


