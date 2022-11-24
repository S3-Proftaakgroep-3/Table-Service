package com.mdma.tableservice.repository;

import com.mdma.tableservice.model.Table;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TableRepository extends MongoRepository<Table, String> {
    Optional<Table> findTableBy(int tableNumber, String restaurantId);
    Table findFirstBy(int tableNumber, String restaurantId);

}
