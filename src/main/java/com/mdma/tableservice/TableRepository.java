package com.mdma.tableservice;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface TableRepository
        extends MongoRepository<Table, UUID> {

    Table findTableByTableNumber(int tableNumber);

    Table findById(String id);
}
