package com.mdma.tableservice;

import com.mdma.tableservice.model.Table;
import com.mdma.tableservice.repository.TableRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;

@SpringBootApplication
public class TableServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(TableServiceApplication.class, args);
    }
}


